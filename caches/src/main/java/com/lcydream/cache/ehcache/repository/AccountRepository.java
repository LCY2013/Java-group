package com.lcydream.cache.ehcache.repository;

import com.lcydream.cache.ehcache.domain.Account;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

/**
 * @program: caches
 * @description: 账户仓储
 * @author: <a href="https://github.com/lcy2013">MagicLuo</a>
 * @create: 2020-06-16 09:42
 */
@Repository
public class AccountRepository {

    //模拟数据库的数据仓储
    private static Map<String, Account> accountMap =
            new ConcurrentHashMap<>();

    //通过atomic实现
    private static AtomicInteger atomicInteger = new AtomicInteger();

    /**
     * 通过数据缓存获取账户信息
     * @param accountName 账户姓名
     * @return 返回账户数据
     */
    public Account getAccountByName(String accountName){
        return accountMap.get(accountName);
    }

    /**
     *  存储Account账户信息
     * @param accountName 账户名称
     */
    public void saveAccount(String accountName){
        accountMap.put(accountName,new Account(atomicInteger.incrementAndGet(),accountName));
    }

}
