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

import com.fufeng.dream.saas.common.util.DataSourceUtils;
import com.fufeng.dream.saas.master.model.MasterTenant;
import com.fufeng.dream.saas.master.repository.MasterTenantRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @program: Java-group
 * @description: #{description}
 * @author: <a href="https://github.com/lcy2013">MagicLuo</a>
 * @create: 2020-06-28 15:28
 */
@Slf4j
@Configuration
public class DataSourceBasedMultiTenantConnectionProviderImpl extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl {

    private static final long serialVersionUID = -7522287771874314380L;

    @Qualifier("masterTenantRepository")
    @Resource
    private MasterTenantRepository masterTenantRepository;

    private final Map<String, DataSource> dataSources = new TreeMap<>();

    @Override
    protected DataSource selectAnyDataSource() {
        if(dataSources.isEmpty()){
            List<MasterTenant> tenants = masterTenantRepository.findAll();
            tenants.forEach(masterTenant-> dataSources.put(masterTenant.getTenant(), DataSourceUtils.wrapperDataSource(masterTenant)));
        }
        return dataSources.values().iterator().next();
    }

    @Override
    protected DataSource selectDataSource(String tenant) {
        if(!dataSources.containsKey(tenant)){
            List<MasterTenant> tenants = masterTenantRepository.findAll();
            tenants.forEach(masterTenant-> dataSources.put(masterTenant.getTenant(),DataSourceUtils.wrapperDataSource(masterTenant)));
        }
        return dataSources.get(tenant);
    }

}
