package com.chris.javabasics.jucpatterns.twophasetermination.jucsample1;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class MyTask implements Runnable {
    // CountDownLatch类可以实现"等待指定次数的CountDown方法被调用"这一功能
    private final CountDownLatch doneLatch;

    private final int context;

    private static final Random random = new Random(314159);

    public MyTask(CountDownLatch doneLatch, int context) {
        this.doneLatch = doneLatch;
        this.context = context;
    }

    @Override
    public void run() {
        // 调用doTask方法执行实际处理
        doTask();
        // 调用countDown方法表示自己的处理已经完成
        // 处理MyTask的run方法的线程会调用countDown方法将计数值减1
        // 当所有MyTask都被处理后，计数值将会变为0，主线程会从await方法中返回
        doneLatch.countDown();
    }

    protected void doTask() {
        String name = Thread.currentThread().getName();
        System.out.println(name + ":MyTask:BEGIN:context = " + context);
        try {
            Thread.sleep(random.nextInt(3000));
        } catch (InterruptedException ignored) {
        } finally {
            System.out.println(name + ":MyTask:END:context = " + context);
        }
    }
}
