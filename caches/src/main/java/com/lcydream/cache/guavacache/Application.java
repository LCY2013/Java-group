package com.lcydream.cache.guavacache;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @program: cache
 * @description: 启用Spring环境
 * @author: <a href="https://github.com/lcy2013">MagicLuo</a>
 * @create: 2020-06-14 17:34
 */
@SpringBootApplication
@EnableCaching
public class Application {

    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext =
                new SpringApplicationBuilder(Application.class)
                .run(args);
        final GuavaCache guavaCache = applicationContext.getBean(GuavaCache.class);
        guavaCache.put("name","lcy");
        guavaCache.get("name");
        guavaCache.put("name","fufeng");
        guavaCache.get("name");
        guavaCache.remove("name");
        guavaCache.put("id","18");
        guavaCache.viewCaches();
        guavaCache.removeAll();
        guavaCache.viewCaches();
        guavaCache.get("name");
    }

}
