package com.fufeng.dream.saas.common.lang;

/**
 * @program: Java-group
 * @description:  租户标识符
 * @author: <a href="https://github.com/lcy2013">MagicLuo</a>
 * @create: 2020-06-28 14:33
 */
public interface ObjectIdentifier<T> {

    T general();

    default String generalIdentifier(){
        return generalIdentifier("");
    }

    String generalIdentifier(String prefix);

}
