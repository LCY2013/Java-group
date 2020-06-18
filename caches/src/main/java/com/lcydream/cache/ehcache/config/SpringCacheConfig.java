package com.lcydream.cache.ehcache.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;

import java.util.Collections;

/**
 * @program: caches
 * @description: Spring cache 配置
 * @author: <a href="https://github.com/lcy2013">MagicLuo</a>
 * @create: 2020-06-15 18:04
 */
//@EnableCaching
//@Configuration
public class SpringCacheConfig {

    @Bean("cacheManager")
    public CacheManager cacheManager(){
        SimpleCacheManager simpleCacheManager =
                new SimpleCacheManager();
        simpleCacheManager.setCaches(Collections.singletonList(new ConcurrentMapCache("cacheManager")));
        return simpleCacheManager;
    }
}
