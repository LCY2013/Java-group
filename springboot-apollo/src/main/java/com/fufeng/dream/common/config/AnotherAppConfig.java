package com.fufeng.dream.common.config;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.context.annotation.Configuration;

/**
 * @program: Java-group
 * @description: apollo 命名空间配置
 * @author: <a href="https://github.com/lcy2013">MagicLuo</a>
 * @create: 2020-06-24 11:07
 */
@Configuration
@EnableApolloConfig(value = {"TEST1.dev-2", "application.yml"}, order = 11)
public class AnotherAppConfig {
}
