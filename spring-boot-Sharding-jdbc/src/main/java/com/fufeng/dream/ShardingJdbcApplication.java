package com.fufeng.dream;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: Java-group
 * @description: 启动入口
 * @author: <a href="https://github.com/lcy2013">MagicLuo</a>
 * @create: 2020-06-19 17:17
 */
@SpringBootApplication
@MapperScan("com.fufeng.dream.mapper")
public class ShardingJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingJdbcApplication.class,args);
    }

}
