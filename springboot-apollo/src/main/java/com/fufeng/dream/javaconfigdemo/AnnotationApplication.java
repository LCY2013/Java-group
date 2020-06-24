package com.fufeng.dream.javaconfigdemo;

import com.fufeng.dream.common.bean.AnnotatedBean;
import com.google.common.base.Charsets;
import com.google.common.base.Strings;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @program: Java-group
 * @description: 注解应用示例
 * @author: <a href="https://github.com/lcy2013">MagicLuo</a>
 * @create: 2020-06-24 11:10
 */
public class AnnotationApplication {

    public static void main(String[] args) throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.fufeng.dream.common");
        AnnotatedBean annotatedBean = context.getBean(AnnotatedBean.class);

        System.out.println("AnnotationApplication Demo. Input any key except quit to print the values. Input quit to exit.");
        while (true) {
            System.out.print("> ");
            String input = new BufferedReader(new InputStreamReader(System.in, Charsets.UTF_8)).readLine();
            if (!Strings.isNullOrEmpty(input) && input.trim().equalsIgnoreCase("quit")) {
                System.exit(0);
            }

            System.out.println(annotatedBean.toString());
        }
    }

}
