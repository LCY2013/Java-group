/*
 * The MIT License (MIT)
 * ------------------------------------------------------------------
 * Copyright © 2019 Ramostear.All Rights Reserved.
 *
 * ProjectName: Java-group
 * @Author : <a href="https://github.com/lcy2013">MagicLuo</a>
 * @date : 2020-06-28
 * @version : 2.0.0-RELEASE
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the “Software”), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */
package com.fufeng.dream.saas.tenant.config;

import com.fufeng.dream.saas.master.repository.MasterTenantRepository;
import com.fufeng.dream.saas.tenant.model.User;
import com.fufeng.dream.saas.tenant.repository.UserRepository;
import com.fufeng.dream.saas.tenant.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.MultiTenancyStrategy;
import org.hibernate.cfg.Environment;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: Java-group
 * @description: #{description}
 * @author: <a href="https://github.com/lcy2013">MagicLuo</a>
 * @create: 2020-06-28 15:33
 */
@Slf4j
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {
        "com.fufeng.dream.saas.tenant.model",
        "com.fufeng.dream.saas.tenant.repository"
})
@EnableJpaRepositories(basePackages = {
        "com.fufeng.dream.saas.tenant.repository",
        "com.fufeng.dream.saas.tenant.repository"
},entityManagerFactoryRef = "tenantEntityManagerFactory"
        ,transactionManagerRef = "tenantTransactionManager")
public class TenantDataSourceConfig {

    @Bean("jpaVendorAdapter")
    public JpaVendorAdapter jpaVendorAdapter(){
        return new HibernateJpaVendorAdapter();
    }

    @Bean(name = "tenantTransactionManager")
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

    @Bean(name = "datasourceBasedMultiTenantConnectionProvider")
    @ConditionalOnBean(name = "masterEntityManagerFactory")
    public MultiTenantConnectionProvider multiTenantConnectionProvider(){
        return new DataSourceBasedMultiTenantConnectionProviderImpl();
    }

    @Bean(name = "currentTenantIdentifierResolver")
    public CurrentTenantIdentifierResolver currentTenantIdentifierResolver(){
        return new CurrentTenantIdentifierResolverImpl();
    }

    @Bean(name = "tenantEntityManagerFactory")
    @ConditionalOnBean(name = "datasourceBasedMultiTenantConnectionProvider")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            @Qualifier("datasourceBasedMultiTenantConnectionProvider")MultiTenantConnectionProvider connectionProvider,
            @Qualifier("currentTenantIdentifierResolver")CurrentTenantIdentifierResolver tenantIdentifierResolver){
        LocalContainerEntityManagerFactoryBean localBean = new LocalContainerEntityManagerFactoryBean();
        localBean.setPackagesToScan(
                User.class.getPackage().getName(),
                UserRepository.class.getPackage().getName(),
                UserService.class.getPackage().getName());

        localBean.setJpaVendorAdapter(jpaVendorAdapter());
        localBean.setPersistenceUnitName("tenant-database-persistence-unit");
        Map<String,Object> properties = new HashMap<>();
        properties.put(Environment.MULTI_TENANT, MultiTenancyStrategy.SCHEMA);
        properties.put(Environment.MULTI_TENANT_CONNECTION_PROVIDER,connectionProvider);
        properties.put(Environment.MULTI_TENANT_IDENTIFIER_RESOLVER,tenantIdentifierResolver);
        properties.put(Environment.DIALECT,"org.hibernate.dialect.MySQL5Dialect");
        properties.put(Environment.SHOW_SQL,true);
        properties.put(Environment.FORMAT_SQL,true);
        properties.put(Environment.HBM2DDL_AUTO,"update");
        localBean.setJpaPropertyMap(properties);
        return localBean;
    }

}
