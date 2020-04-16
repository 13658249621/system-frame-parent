package com.system.frame.config;
import com.system.frame.common.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 *  全局异常
 */

@Slf4j
@ControllerAdvice
@Configuration
public class AllExceptionAdvice {
    /**
     * 全局异常捕捉处理
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResponseData errorHandler(Exception e) {
        e.printStackTrace();
        if(e instanceof RuntimeException){
            return ResponseData.error(e.getMessage());
        }
        return ResponseData.error("程序出现异常！");
    }
}
