package com.system.frame.common;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fxbin
 * @create 2020-03-11 11:13
 * description:
 */
public class HttpContext { 
    /**
     * 获取请求的ip地址
     *
     * @author cyy
     * @Date 2018/7/23 下午3:44
     */
    public static String getIp() {
        HttpServletRequest request = HttpContext.getRequest();
        if (request == null) {
            return "127.0.0.1";
        } else {
            return request.getRemoteHost();
        }
    }

    /**
     * 获取当前请求的Request对象
     *
     * @author cyy
     * @Date 2018/7/23 下午3:44
     */
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            return null;
        } else {
            return requestAttributes.getRequest();
        }
    }

    /**
     * 获取当前请求的Response对象
     *
     * @author cyy
     * @Date 2018/7/23 下午3:44
     */
    public static HttpServletResponse getResponse() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            return null;
        } else {
            return requestAttributes.getResponse();
        }
    }

    /**
     * 获取所有请求的值
     *
     * @author cyy
     * @Date 2018/7/23 下午3:44
     */
    public static Map<String, String> getRequestParameters() {
        HashMap<String, String> values = new HashMap<>();
        HttpServletRequest request = HttpContext.getRequest();
        if (request == null) {
            return values;
        }
        Enumeration enums = request.getParameterNames();
        while (enums.hasMoreElements()) {
            String paramName = (String) enums.nextElement();
            String paramValue = request.getParameter(paramName);
            values.put(paramName, paramValue);
        }
        return values;
    }

}

