package com.fufeng.dream.utils;

import org.json.JSONObject;

/**
 * @program: Java-group
 * @description: json 结果集处理类
 * @author: <a href="https://github.com/lcy2013">MagicLuo</a>
 * @create: 2020-06-18 17:25
 */
public interface JSONResult {

    /**
     * JSON 化返回结果集
     *
     * @param status  状态
     * @param message 消息
     * @param result  结果数据
     * @return JSON数据集
     */
    static String fillResultString(Integer status, String message, Object result) {
        JSONObject resultJson = new JSONObject() {
            {
                put("status", status);
                put("message", message);
                put("result", result);
            }
        };
        return resultJson.toString();
    }

}
