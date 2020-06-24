package com.fufeng.dream.mockito.repository;

import com.fufeng.dream.mockito.domain.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @program: Java-group
 * @description: user 数据仓库
 * @author: <a href="https://github.com/lcy2013">MagicLuo</a>
 * @create: 2020-06-24 13:49
 */
@Repository
public class UserRepository {

    /**
     * 用户数据底层存储
     */
    private final Map<String, User> userMap = Map.of("fufeng",new User(7,"fufeng"));

    /**
     *  存储用户信息
     * @param user 用户
     * @return 添加用户信息是否成功
     */
    public boolean addUser(User user){
        if(Objects.nonNull(user)){
            return Objects.nonNull(userMap.put(user.getName(),user));
        }
        return false;
    }

    /**
     *  获取对应的用户数据
     * @param name 名称
     * @return 用户
     */
    public User getUser(String name){
        return userMap.get(name);
    }

}
