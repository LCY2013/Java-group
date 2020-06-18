package com.lcydream.cache.ehcache.service;

import com.lcydream.cache.ehcache.domain.Account;
import com.lcydream.cache.ehcache.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @program: caches
 * @description: 账户服务信息
 * @author: <a href="https://github.com/lcy2013">MagicLuo</a>
 * @create: 2020-06-15 17:31
 */
@Service
@Slf4j
public class AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    /**
     * 通过spring缓存注解实现方法级别的缓存设置
     * @param accountName 账户姓名
     * @return 账户信息，如此存在就从缓存中查询，如果不存在就从数据库中查询
     */
    @Cacheable(key = "#accountName",value = "accountCache")
    public Account getAccountByName(String accountName){
        log.info("---缓存 getAccountByName "+accountName+" ----");
        //从数据库中获取account
        return getAccount(accountName);
    }

    /**
     * 模拟从数据库查询账户信息
     * @param accountName 账户用户名称
     * @return 返回账户数据
     */
    private Account getAccount(String accountName) {
        log.info("---从数据库中获取账户信息 "+accountName+" ---");
        return accountRepository.getAccountByName(accountName);
    }

    /**
     * 保存账户信息
     * @param accountName 账户名称
     */
    @CachePut(key = "#accountName",value = "accountCache")
    public Account saveAccount(String accountName){
        log.info("---存储账户信息 "+accountName+" ---");
        accountRepository.saveAccount(accountName);
        return accountRepository.getAccountByName(accountName);
    }

}
