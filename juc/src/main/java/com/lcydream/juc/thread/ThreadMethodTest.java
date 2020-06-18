package com.lcydream.juc.thread;

/**
 * @program: Java-group
 * @description: #{description}
 * @author: <a href="https://github.com/lcy2013">MagicLuo</a>
 * @create: 2020-05-19 21:36
 */
public class ThreadMethodTest {

    public static void main(String[] args) throws InterruptedException {
        testJoin();
    }

    public static void testJoin() throws InterruptedException {
        Thread t1 = null;
        Thread t2 = null;
        Thread t3 = null;
        Thread t4 = null;
        t1 = new Thread(()->{
            System.out.println("t1");
        });
        Thread finalT1 = t1;
        t2 = new Thread(()->{
            try {
                finalT1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2");
        });
        Thread finalT2 = t2;
        t3 = new Thread(()->{
            try {
                finalT2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t3");
        });

        Thread finalT3 = t3;
        t4 = new Thread(()->{
            try {
                finalT3.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t4");
        });

        t4.start();
        t3.start();
        t2.start();
        t1.start();

    }
}
