package com.fufeng.dream.saas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @program: Java-group
 * @description: saas 平台启动入口
 * @author: <a href="https://github.com/lcy2013">MagicLuo</a>
 * @create: 2020-06-24 14:30
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SaasApplication {

    public static void main(String[] args) {
        SpringApplication.run(SaasApplication.class,args);
    }

}
