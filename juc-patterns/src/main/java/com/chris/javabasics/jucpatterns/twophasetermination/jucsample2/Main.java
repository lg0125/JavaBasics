package com.chris.javabasics.jucpatterns.twophasetermination.jucsample2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 程序实现"让三个线程处理一项分为五个阶段的工作"
 * 假设要求实现"除非三个线程都结束第N阶段的处理，否则哪个线程都不能进入第N+1阶段"的功能
 *      为了使线程能在这五个阶段中保持"步调一致"，这需要使用CyclicBarrier类
 * 为了通知主线程"所有工作的各个阶段都已经结束"，使用CountDownLatch类
 * */
public class Main {
    private static final int THREADS = 3; // 线程的个数

    public static void main(String[] args) {
        System.out.println("BEGIN");

        // 由ExecutorService提供进行工作的线程
        ExecutorService service = Executors.newFixedThreadPool(THREADS);

        // 屏障被解除时的操作
        // 在创建CyclicBarrier的实例时，可以知道Runnable对象
        // 该对象被称为屏障操作barrier action
        // 每次屏障被解除后，该屏障操作都会被执行
        Runnable barrierAction = () -> System.out.println("Barrier Action!");

        // CyclicBarrier用于使线程步调一致
        // 为了使线程能在这五个阶段中保持"步调一致"，这需要使用CyclicBarrier类
        CyclicBarrier phaseBarrier = new CyclicBarrier(
                THREADS,
                barrierAction
        );

        // CountDownLatch用于确认工作是否结束
        // 为了通知主线程"所有工作的各个阶段都已经结束"，使用CountDownLatch类
        CountDownLatch doneLatch = new CountDownLatch(THREADS);

        try {
            // 开始工作
            for (int t = 0; t < THREADS; t++)
                service.execute(
                        new MyTask(
                                phaseBarrier,
                                doneLatch,
                                t
                        )
                );

            // 等待工作结束
            System.out.println("AWAIT");

            doneLatch.await();
        } catch (InterruptedException ignored) {
        } finally {
            service.shutdown();

            System.out.println("END");
        }
    }
}
