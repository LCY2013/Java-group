package com.fufeng.dream.controller;

import com.fufeng.dream.utils.JSONResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *  curl -I http://127.0.0.1:8080
 *  curl -I http://127.0.0.1:8080/users
 *  curl -H "Content-Type: application/json" -X POST -d '{"username":"admin","password":"123456"}'  http://127.0.0.1:8080/login
 * @program: Java-group
 * @description: 用户功能控制器
 * @author: <a href="https://github.com/lcy2013">MagicLuo</a>
 * @create: 2020-06-18 17:15
 */
@RestController
public class UserController {

    @RequestMapping("/")
    Map<String,Object> getUser(){
        Map<String,Object> result = new HashMap<>();
        result.put("1","fufeng");
        return result;
    }

    @GetMapping(value = "/users",produces = "application/json;charset=UTF-8")
    public String userList(){
        ArrayList<String> users =  new ArrayList<String>(){{
            add("fufeng");
            add("lcy");
            add("jerry");
        }};
        return JSONResult.fillResultString(200,"成功",users);
    }

    @GetMapping(value = "/add/users",produces = "application/json;charset=UTF-8")
    public String addUser(){
        return JSONResult.fillResultString(200,"成功","");
    }

    @GetMapping(value = "/delete/users",produces = "application/json;charset=UTF-8")
    public String deleteUser(){
        return JSONResult.fillResultString(200,"成功","");
    }
}
