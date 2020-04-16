package com.system.frame.util;


import org.apache.commons.lang3.StringUtils;

import java.util.Random;


public class SaltUtil {


    public static String getRandomSalt() {
        return SaltUtil.getRandomString(5);
    }


    public static String md5Encrypt(String password, String salt) {
        if (StringUtils.isEmpty(password)) {
            throw new IllegalArgumentException("密码不能为空！");
        } else {
            return MD5Util.encrypt(password + salt);
        }
    }

    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

}
