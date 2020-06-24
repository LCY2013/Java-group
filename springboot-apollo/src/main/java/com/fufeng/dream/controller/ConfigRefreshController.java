package com.fufeng.dream.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: Java-group
 * @description: 配置刷新控制器测试用例
 * @author: <a href="https://github.com/lcy2013">MagicLuo</a>
 * @create: 2020-06-22 17:09
 */
@RestController
public class ConfigRefreshController {

    @Value("${name:fufeng}")
    private String name;

    @GetMapping("/get/name")
    public String getName() {
        return "name : "+name;
    }
}
