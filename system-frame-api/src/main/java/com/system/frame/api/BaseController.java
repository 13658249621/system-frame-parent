package com.system.frame.api;
import com.system.frame.common.HttpContext;
import com.system.frame.core.UserInfoHolder;
import com.system.frame.entity.User;

public class BaseController   {
    /**
     * 获取请求参数
     *
     * @param name
     * @return
     */
    protected String getPara(String name) {
        return HttpContext.getRequest().getParameter(name);
    }

    /**
     * 请求域中放值
     *
     * @param name
     * @param value
     */
    protected void setAttr(String name, Object value) {
        HttpContext.getRequest().setAttribute(name, value);
    }

    /**
     * 获取用户信息
     *
     * @return
     */
    protected User getUser() {
        User user = UserInfoHolder.getUser();
        return user;
    }


}
