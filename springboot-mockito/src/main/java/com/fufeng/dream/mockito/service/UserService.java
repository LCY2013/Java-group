package com.fufeng.dream.mockito.service;

import com.fufeng.dream.mockito.domain.User;
import com.fufeng.dream.mockito.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @program: Java-group
 * @description:
 *  用户实现类
 * @author: <a href="https://github.com/lcy2013">MagicLuo</a>
 * @create: 2020-06-24 13:54
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     *  存储用户信息
     * @param user 用户
     * @return 添加用户信息是否成功
     */
    public boolean addUser(User user){
        return userRepository.addUser(user);
    }

    /**
     *  获取对应的用户数据
     * @param name 名称
     * @return 用户
     */
    public User getUser(String name){
        return userRepository.getUser(name);
    }

}
