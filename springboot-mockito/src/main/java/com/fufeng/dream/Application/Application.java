package com.fufeng.dream.Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author luocy
 * @description 启动类
 * @program Java-group
 * @create 2021-03-30
 * @since 1.0
 */
@SpringBootApplication(scanBasePackages = "com.fufeng.dream.Application")
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

}
