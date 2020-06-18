package com.lcydream.cache.ehcache;

import com.lcydream.cache.ehcache.domain.Account;
import com.lcydream.cache.ehcache.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: caches
 * @description: AccountService 测试用例
 * @author: <a href="https://github.com/lcy2013">MagicLuo</a>
 * @create: 2020-06-15 17:54
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes={AccountApplication.class})
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void accountServiceTest(){
        Account fufeng = accountService.getAccountByName("fufeng");
        System.out.println(fufeng);
        accountService.saveAccount("fufeng");
        fufeng = accountService.getAccountByName("fufeng");
        System.out.println(fufeng);
    }
}
