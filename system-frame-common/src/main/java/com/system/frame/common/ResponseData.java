package com.system.frame.common;


import lombok.Data;

@Data
public class ResponseData {

    public static final String DEFAULT_SUCCESS_MESSAGE = "请求成功";

    public static final String DEFAULT_ERROR_MESSAGE = "网络异常";

    public static final Integer DEFAULT_SUCCESS_CODE = 200;
    public static final Integer DEFAULT_NO_LOGIN = 405;

    public static final Integer DEFAULT_ERROR_CODE = 300;

    /**
     * 请求是否成功
     */
    private Boolean success;

    /**
     * 响应状态码
     */
    private Integer successcode;

    /**
     * 响应信息
     */
    private String messages;

    /**
     * 响应对象
     */
    private Object data;

    /**
     * 响应对象
     */
    private String power;

    public ResponseData() {
    }

    public ResponseData(Boolean success, Integer code, String message, Object data) {
        this.success = success;
        this.successcode = code;
        this.messages = message;
        this.data = data;
    }

    public static SuccessResponseData success() {
        return new SuccessResponseData();
    }

    public static SuccessResponseData success(Object object) {
        return new SuccessResponseData(object);
    }

    public static SuccessResponseData success( String message,Object object) {
        return new SuccessResponseData( message,object);
    }

    public static SuccessResponseData success(Integer code, String message, Object object) {
        return new SuccessResponseData(code, message, object);
    }

    public static ErrorResponseData error(String message) {
        return new ErrorResponseData(message);
    }

    public static ErrorResponseData error(Integer code, String message) {
        return new ErrorResponseData(code, message);
    }

    public static ErrorResponseData error(Integer code, String message, Object object) {
        return new ErrorResponseData(code, message, object);
    }
    public ResponseData(Boolean success, Integer code, String message, String power) {
        this.success = success;
        this.successcode = code;
        this.messages = message;
        this.power = power;
    }
    public static SuccessResponseData successPower(Boolean flag,Integer code, String message, String power) {
        return new SuccessResponseData(flag,code, message, power);
    }

}
