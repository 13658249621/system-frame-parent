package com.system.frame;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author fxbin
 * @create 2020-03-24 10:47
 * description:   启动类
 */
@SpringBootApplication
@MapperScan("com.system.frame.mapper")
@EnableSwagger2Doc
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
