package com.fufeng.dream.springbootdemo.refresh;

import com.ctrip.framework.apollo.core.ConfigConsts;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.fufeng.dream.springbootdemo.config.SampleRedisConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @program: Java-group
 * @description: springboot 开启属性刷新
 * @author: <a href="https://github.com/lcy2013">MagicLuo</a>
 * @create: 2020-06-24 11:34
 */
@ConditionalOnProperty("redis.cache.enabled")
@Component
public class SpringBootApolloRefreshConfig {

    private static final Logger logger = LoggerFactory.getLogger(SpringBootApolloRefreshConfig.class);

    private final SampleRedisConfig sampleRedisConfig;
    private final RefreshScope refreshScope;

    public SpringBootApolloRefreshConfig(
            final SampleRedisConfig sampleRedisConfig,
            final RefreshScope refreshScope) {
        this.sampleRedisConfig = sampleRedisConfig;
        this.refreshScope = refreshScope;
    }

    @ApolloConfigChangeListener(value = {ConfigConsts.NAMESPACE_APPLICATION, "TEST1.dev-2", "application.yml"},
            interestedKeyPrefixes = {"redis.cache."})
    public void onChange(ConfigChangeEvent changeEvent) {
        logger.info("before refresh {}", sampleRedisConfig.toString());
        refreshScope.refresh("sampleRedisConfig");
        logger.info("after refresh {}", sampleRedisConfig.toString());
    }
}
