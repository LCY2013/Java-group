package com.fufeng.dream.domain;

import lombok.Data;

/**
 * @program: Java-group
 * @description: 用户信息定义
 * @author: <a href="https://github.com/lcy2013">MagicLuo</a>
 * @create: 2020-06-18 17:59
 */
@Data
public class AccountCredentials {
    /**
     * 用户姓名
     */
    private String username;
    /**
     * 用户密码
     */
    private String password;
}
