package com.chris.javabasics.jucpatterns.threadpool.jucsample;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

/**
 * 发生工作请求的类
 * <p>
 * 发生工作请求
 *      创建Request的实例
 *      将该实例传递给Channel类的putRequest方法
 * */
public class ClientThread extends Thread {
    private final ExecutorService executorService;

    private static final Random random = new Random();

    public ClientThread(String name, ExecutorService executorService) {
        super(name);
        this.executorService = executorService;
    }

    public void run() {
        try {
            for (int i = 0; true; i++) {
                Request request = new Request(getName(), i);

                executorService.execute(request);

                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException ignored) {
        } catch (RejectedExecutionException e) {
            System.out.println(getName() + " : " + e);
        }
    }
}
