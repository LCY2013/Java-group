package com.fufeng.dream.common.config;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.context.annotation.Configuration;

/**
 * @program: Java-group
 * @description: apollo 配置信息
 * @author: <a href="https://github.com/lcy2013">MagicLuo</a>
 * @create: 2020-06-24 11:08
 */
@Configuration
@EnableApolloConfig(value = "application", order = 10)
public class AppConfig {
}
