package com.fufeng.dream.xmlconfigdemo.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: Java-group
 * @description: xml 实体定义信息
 * @author: <a href="https://github.com/lcy2013">MagicLuo</a>
 * @create: 2020-06-24 11:24
 */
public class XmlBean {

    private static final Logger logger = LoggerFactory.getLogger(XmlBean.class);

    private int timeout;
    private int batch;

    public void setTimeout(int timeout) {
        logger.info("updating timeout, old value: {}, new value: {}", this.timeout, timeout);
        this.timeout = timeout;
    }

    public void setBatch(int batch) {
        logger.info("updating batch, old value: {}, new value: {}", this.batch, batch);
        this.batch = batch;
    }

    public int getTimeout() {
        return timeout;
    }

    public int getBatch() {
        return batch;
    }

    @Override
    public String toString() {
        return String.format("[XmlBean] timeout: %d, batch: %d", timeout, batch);
    }

}
