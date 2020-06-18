package com.lcydream.cache.ehcache.domain;

import lombok.*;

/**
 * @program: caches
 * @description: 账户信息实体
 * @author: <a href="https://github.com/lcy2013">MagicLuo</a>
 * @create: 2020-06-15 17:28
 */
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    private Integer id;

    private String name;

    public Account(String name) {
        this.name = name;
    }
}
