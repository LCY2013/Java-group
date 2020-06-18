package com.lcydream.cache.ehcache.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.util.Objects;

/**
 * @program: caches
 * @description: Ehcache 配置信息
 * @author: <a href="https://github.com/lcy2013">MagicLuo</a>
 * @create: 2020-06-13 09:51
 */
@Configuration
@EnableCaching
public class EhcacheConfig {

    //通过定义缓存类型是Ehcache使用spring缓存抽象简化操作
    @Bean
    public CacheManager cacheManager(){
        return new EhCacheCacheManager(
                Objects.requireNonNull(ehCacheManager().getObject()));
    }

    @Bean
    public EhCacheManagerFactoryBean ehCacheManager(){
        EhCacheManagerFactoryBean ehCacheManagerFactoryBean =
                new EhCacheManagerFactoryBean();
        ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache/ehcache.xml"));
        ehCacheManagerFactoryBean.setShared(true);
        return ehCacheManagerFactoryBean;
    }
}
