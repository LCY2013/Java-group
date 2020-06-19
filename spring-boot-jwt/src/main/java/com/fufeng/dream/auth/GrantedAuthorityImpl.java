package com.fufeng.dream.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

/**
 * @program: Java-group
 * @description: 认证授权实现
 * @author: <a href="https://github.com/lcy2013">MagicLuo</a>
 * @create: 2020-06-18 18:00
 */
@Data
@AllArgsConstructor
public class GrantedAuthorityImpl implements GrantedAuthority {

    /**
     * 认证信息
     */
    private String authority;

    @Override
    public String getAuthority() {
        return this.authority;
    }

}
