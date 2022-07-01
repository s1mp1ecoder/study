package com.zxs.study.jvm;

import java.util.concurrent.TimeUnit;

public class StackOverFlowTest {

    static int count = 0;

    static void run() {
        count++;
        run();
    }

    static void run2() throws InterruptedException {
        TimeUnit.MICROSECONDS.sleep(1);
        run2();
    }

    public static void main(String[] args) throws InterruptedException {
        try {
            run();
        } catch (Throwable e) {
            System.out.println(Thread.currentThread().getName() + ":" + count);
        }

        TimeUnit.MILLISECONDS.sleep(1000);

        new Thread(() -> {
            try {
                run2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "test").start();

    }


}
