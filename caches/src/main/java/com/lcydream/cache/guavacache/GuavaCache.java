package com.lcydream.cache.guavacache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @program: caches
 * @description: Guava 缓存使用
 * @author: <a href="https://github.com/lcy2013">MagicLuo</a>
 * @create: 2020-06-14 17:05
 */
@Component
@Slf4j
public class GuavaCache {

    //定义一个Guava 本地缓存
    private static LoadingCache<String, String> cache = CacheBuilder.newBuilder()
            .maximumSize(10) //设置最大条目数
            .expireAfterAccess(10, TimeUnit.SECONDS) //设置缓存失效时间，主要针对数据读或者写
            .removalListener(notification ->
                    log.info("缓存数据被清除:" + notification.getKey() + "-" + notification.getValue())
            ).build(new CacheLoader<String, String>() {
                @Override
                public String load(String key) throws Exception {
                    log.info("数据缓存加载:" + key);
                    return "GuavaCache-" + key;
                }
            });

    /**
     * 通过key获取缓存中的value
     * 如果key不存在，将调用Cache 中的load加载一个定义的其他key数据
     *
     * @param key 获取key
     * @return 返回value
     */
    public String get(String key) {
        try {
            final String value = cache.get(key);
            log.info("get value :" + value);
            return value;
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 移除指定key缓存数据
     *
     * @param key 缓存key
     */
    public void remove(String key) {
        cache.invalidate(key);
        log.info("remove key : " + key);
    }

    /**
     * 移除所有缓存数据
     */
    public void removeAll(){
        cache.invalidateAll();
        log.info("remove all success");
    }

    /**
     * 保存缓存数据
     * 如果缓存中已经存在该key，则会先移除这个key，这时会出发RemoveListener监听器，触发后才会添加这个key和value
     *
     * @param key
     * @param value
     */
    public void put(String key,String value){
        cache.put(key,value);
        log.info("保存数据成功: key->"+key+" value->"+value);
    }

    /**
     * 查询缓存中所有的map数据
     *
     * @return 返回map数据
     */
    public ConcurrentMap<String,String> viewCaches(){
        final ConcurrentMap<String, String> mapCaches = cache.asMap();
        log.info("缓存中所有数据:"+mapCaches);
        return mapCaches;
    }
}
