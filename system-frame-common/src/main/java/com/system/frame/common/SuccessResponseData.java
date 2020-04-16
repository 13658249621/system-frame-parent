package com.system.frame.common;

/**
 * @author fxbin
 * @create 2020-03-11 11:05
 * description:   测试
 */
public class SuccessResponseData extends ResponseData {

    public SuccessResponseData() {
        super(true, DEFAULT_SUCCESS_CODE, DEFAULT_SUCCESS_MESSAGE, null);
    }

    public SuccessResponseData(Object object) {
        super(true, DEFAULT_SUCCESS_CODE, DEFAULT_SUCCESS_MESSAGE, object);
    }
    public SuccessResponseData(String message, Object object) {
        super(true, DEFAULT_SUCCESS_CODE, message, object);
    }

    public SuccessResponseData(Integer code, String message, Object object) {
        super(true, code, message, object);
    }
    public SuccessResponseData(Boolean flag,Integer code, String message, String power) {
        super(flag, code, message, power);
    }
}
