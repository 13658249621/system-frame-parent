package com.system.frame.api;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.system.frame.common.JwtPayLoad;
import com.system.frame.common.ResponseData;
import com.system.frame.core.UserInfoHolder;
import com.system.frame.entity.User;
import com.system.frame.service.UserService;
import com.system.frame.util.JwtTokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Wrapper;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@Controller
@Api(tags = "登录登出注册接口",description = "登录登出注册接口")
public class LoginController extends BaseController {
    @Autowired
    private UserService userService;


    @PostMapping("/loginOut")
    @ResponseBody
    @ApiOperation(value = "退出登录", notes = "退出登录")
    public ResponseData loginOut(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session != null) {
            session.invalidate();
        }
        return ResponseData.success();
    }


    @PostMapping("/login")
    @ResponseBody
    @ApiOperation(value = "登录", notes = "登录")
    public ResponseData login(@ApiParam(value = "用户名", required = true) String uname, @ApiParam(value = "密码", required = true) String password, HttpServletRequest request) {


        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uname", uname);
        User user = userService.getOne(queryWrapper);
        // 用户未注册
        if (Objects.isNull(user)) {
            return   ResponseData.error(301,"用户尚未注册");
        }else{
            queryWrapper.eq("password", password);
             user = userService.getOne(queryWrapper);
            // 密码错误
             if(Objects.isNull(user)){
               return   ResponseData.error("密码错误");
             }
        }

        JwtPayLoad payLoad = new JwtPayLoad(user.getUid().longValue(), user.getUname(), user.getPassword());
        String token = JwtTokenUtil.generateToken(payLoad);
        HttpSession session = request.getSession();
        if(session!=null){
            session.setAttribute("user",user);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        user.setPassword("");
        map.put("user", user);
        return ResponseData.successPower(true,200,"登陆成功",user.getPower());
    }


//    @GetMapping("/checkToken")
//    @ResponseBody
//    @ApiOperation(value = "检测token是不是有效", notes = "检测token是不是有效")
//    public ResponseData checkIslogin(HttpServletRequest request) {
//        String token = request.getHeader("token");
//        Boolean aBoolean = JwtTokenUtil.checkToken(token);
//        return ResponseData.success(aBoolean);
//    }

    @PostMapping("/register")
    @ResponseBody
    @ApiOperation(value = "用户注册", notes = "用户注册")
    public ResponseData register(@ApiParam(value = "用户对象", required = true) User user) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("uname",user.getUname());
        User user1 = userService.getOne(queryWrapper);
        if(Objects.nonNull(user1)){
            return ResponseData.error("用户名已被注册，请重新输入！");
        }
        userService.save(user);
        return ResponseData.success("注册成功",user);
    }

    @PostMapping("/updateUser")
    @ResponseBody
    @ApiOperation(value = "用户信息修改", notes = "用户信息修改")
    public ResponseData updateUser(@ApiParam(value = "用户对象", required = true)  User user) {
        userService.saveOrUpdate(user);
        return ResponseData.success(user);
    }

    @PostMapping("/updatePassWord")
    @ResponseBody
    @ApiOperation(value = "用户修改密码", notes = "用户修改密码")
    public ResponseData updateUser(@ApiParam(value = "新密码", required = true) String newPassword ,@ApiParam(value = "旧密码", required = true)String oldPassword) {

        if(!UserInfoHolder.getUser().getPassword().equals(oldPassword)){
            return ResponseData.error("旧密码输入不正确！");
        }
        User user = UserInfoHolder.getUser();
        user.setPassword(newPassword);
        userService.save(user);
        return ResponseData.success("修改密码成功！");
    }


}


