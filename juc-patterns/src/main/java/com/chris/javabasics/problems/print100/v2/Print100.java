package com.chris.javabasics.problems.print100.v2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Print100 {
    private static int number = 1;

    private static final int MAX_COUNT = 100;

    private static final int NUM_THREADS = 5;

    public static void main(String[] args) {
        //  使用了ExecutorService接口和Executors.newFixedThreadPool()方法来创建一个固定大小的线程池
        //  我们假设使用5个线程来打印数字，因此创建了一个固定大小为5的线程池
        //  然后，我们循环提交NumberRunnable任务给线程池执行
        //  NumberRunnable是打印数字的线程任务类
        //      在run方法中，使用synchronized关键字锁定PrintNumbers.class对象，确保每个线程在访问共享资源前都进入互斥状态
        //  线程循环执行打印操作，当number超过最大值MAX_COUNT时，跳出循环
        //  在每次循环中，线程打印当前数字，并将number递增
        //  最后，调用executor.shutdown()方法关闭线程池，释放线程资源

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_THREADS; i++)
            executor.execute(() -> {
                while (true) {
                    synchronized (Print100.class) {
                        if (number > MAX_COUNT)
                            break;

                        System.out.println(
                                Thread.currentThread().getName() + ": " + number
                        );

                        number++;
                    }
                }
            });

        executor.shutdown();
    }
}
