package com.lcydream.cache.ehcache.demo;

import lombok.extern.slf4j.Slf4j;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * @program: caches
 * @description: ehcache 使用示例
 * @author: <a href="https://github.com/lcy2013">MagicLuo</a>
 * @create: 2020-06-13 10:04
 */
@Slf4j
public class EhcacheDemo {

    private static CacheManager cacheManager;

    static {
        String path = EhcacheDemo.class.getResource("/").getPath()+"ehcache/ehcache.xml";
        cacheManager = new CacheManager(path);
    }

    public static void main(String[] args) {
        cacheManager.addCacheIfAbsent("ehcache");
        final Cache ehcache = cacheManager.getCache("ehcache");
        ehcache.put(new Element("name","fufeng"));
        final Element name = ehcache.get("name");
        log.info("name = "+name);
        //获取磁盘存储大小
        final int diskStoreSize = ehcache.getDiskStoreSize();
        log.info("diskStoreSize = "+diskStoreSize);
    }
}
