package com.fufeng.dream.mockito.service;

import com.fufeng.dream.mockito.domain.User;
import com.fufeng.dream.mockito.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: Java-group
 * @description: UserService mock 测试
 * @author: <a href="https://github.com/lcy2013">MagicLuo</a>
 * @create: 2020-06-24 13:57
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    /**
     *  注入一个userService bean
     */
    @Autowired
    private UserService userService;

    /**
     *  注入一个mock 用户数据仓库
     */
    @MockBean
    private UserRepository userRepository;

    @Test
    public void getUserByName(){
        //通过普通的UserService去调用
        final User user = userService.getUser("fufeng");
        Assert.assertNotNull(user);
        Assert.assertEquals(user.getName(),"fufeng");
        Assert.assertEquals(user.getId(), Integer.valueOf(7));
    }

    @Test
    public void getMockUserByName(){
        //模拟一个Mock UserRepository,当查询fufeng的时候返回id为1，用户名为fufeng的用户
        Mockito.when(userRepository.getUser("fufeng"))
                .thenReturn(new User(1,"fufeng"));
        //通过UserService去调用getUserByName
        final User user = userService.getUser("fufeng");
        Assert.assertNotNull(user);
        Assert.assertEquals(user.getName(),"fufeng");
        Assert.assertEquals(user.getId(), Integer.valueOf(7));
    }

}
