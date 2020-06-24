package com.fufeng.dream.xmlconfigdemo;

import com.fufeng.dream.xmlconfigdemo.bean.XmlBean;
import com.google.common.base.Charsets;
import com.google.common.base.Strings;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @program: Java-group
 * @description: xml 应用配置信息
 * @author: <a href="https://github.com/lcy2013">MagicLuo</a>
 * @create: 2020-06-24 11:23
 */
public class XmlApplication {

    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        XmlBean xmlBean = context.getBean(XmlBean.class);

        System.out.println("XmlApplication Demo. Input any key except quit to print the values. Input quit to exit.");
        while (true) {
            System.out.print("> ");
            String input = new BufferedReader(new InputStreamReader(System.in, Charsets.UTF_8)).readLine();
            if (!Strings.isNullOrEmpty(input) && input.trim().equalsIgnoreCase("quit")) {
                System.exit(0);
            }

            System.out.println(xmlBean.toString());
        }
    }

}
