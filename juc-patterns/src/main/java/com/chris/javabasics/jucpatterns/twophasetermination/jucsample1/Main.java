package com.chris.javabasics.jucpatterns.twophasetermination.jucsample1;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int TASKS = 10; // 工作的个数

    /**
     * 实现——让线程处理10项MyTask工作并等待10项工作都处理完成的功能
     * "等待10项工作都处理完成"使用CountDownLatch类来完成
     * */
    public static void main(String[] args) {
        System.out.println("BEGIN");

        // 1.准备一个进行工作的ExecutorService对象(service)
        ExecutorService service = Executors.newFixedThreadPool(5);

        // 2.创建一个CountDownLatch类的实例(doneLatch)
        CountDownLatch doneLatch = new CountDownLatch(TASKS);

        try {
            // 开始工作
            // 调用execute方法执行(内部启动线程)TASKS个MyTask
            for (int t = 0; t < TASKS; t++)
                service.execute(new MyTask(doneLatch, t));

            System.out.println("AWAIT");

            // 等待工作结束
            // 调用await方法等待doneLatch的计数值变为0
            doneLatch.await();
        } catch (InterruptedException ignored) {
        } finally {
            // 调用shutdown方法终止service
            // ExecutorService的shutdown方法
            // 用于优雅地终止在该ExecutorService中启动的所有线程
            service.shutdown();

            System.out.println("END");
        }
    }
}
