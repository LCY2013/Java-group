package com.fufeng.dream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: Java-group
 * @description: Apollo 使用用例
 *  env： 应用使用 Apollo 哪个环境，例如设置为 DEV 就是指定使用开发环境，
 *          如果设置为 PRO 就是制定使用生产环境。
 *  apollo.configService： 指定配置中心的地址，跳过 meta 的配置，
 *          在测试时指定 meta 地址无效果。如果 Apollo 是部署在 Kubernetes 中，
 *          则必须设置该参数为配置中心地址，如果 Apollo 不是在 Kubernetes 环境中，
 *          可以不设置此参数，只设置 meta 参数即可。一般情况下，
 *          configService 和 meta 值一致。
 *   启动参数: -Dapollo.configService=http://192.168.0.111:8070 -Denv=DEV
 * @author: <a href="https://github.com/lcy2013">MagicLuo</a>
 * @create: 2020-06-22 17:04
 */
@SpringBootApplication
public class ApolloApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApolloApplication.class,args);
    }

}
