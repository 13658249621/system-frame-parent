package com.system.frame.core;


import cn.hutool.core.convert.Convert;
import com.system.frame.entity.User;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 用户相关信息上下文对象
 */
public class UserInfoHolder {
    private static ThreadLocal<User> users = new ThreadLocal<>();

    public static User getUser() {
        User User = users.get();
        return User;

    }

    public static void setUser(User User) {
        users.set(User);
    }




}
