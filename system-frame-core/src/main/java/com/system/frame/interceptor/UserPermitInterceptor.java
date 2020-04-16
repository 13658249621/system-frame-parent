package com.system.frame.interceptor;


import cn.hutool.json.JSONUtil;
import com.system.frame.common.JwtPayLoad;
import com.system.frame.common.ResponseData;
import com.system.frame.core.UserInfoHolder;

import com.system.frame.entity.User;
import com.system.frame.mapper.UserMapper;
import com.system.frame.util.JwtTokenUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/***
 *  用户权限控制拦截器
 */
@Component
@Qualifier("userInterceptor")
public class UserPermitInterceptor implements HandlerInterceptor {
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {

        String token = request.getHeader("token");
        response.setCharacterEncoding("utf-8");
        if (StringUtils.isNotEmpty(token)) {
            JwtPayLoad jwtPayLoad = JwtTokenUtil.getJwtPayLoad(token);
            Long userId = jwtPayLoad.getUserId();
            User sysUser = new User();
            sysUser.setUid(userId.intValue());
            List<User> list = userMapper.getList(sysUser);
            if(list.size()>0){
                UserInfoHolder.setUser(list.get(0));
                return true;
            }
            response.getWriter().write(ResponseData.error(ResponseData.DEFAULT_NO_LOGIN,"用户不存在！").toString());
            return false;
        } else {
            if (request.getSession() != null) {
                User user = (User) request.getSession().getAttribute("user");
                if (user != null) {
                    UserInfoHolder.setUser(user);
                    return true;
                }
            }
            response.getWriter().write(JSONUtil.parse(ResponseData.error(ResponseData.DEFAULT_NO_LOGIN,"你还没有登录,请先登录！")).toString());
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}