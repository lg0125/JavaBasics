package com.chris.javabasics.jucpatterns.guardedsuspension.sample;

import com.chris.javabasics.jucpatterns.guardedsuspension.sample.Request;
import com.chris.javabasics.jucpatterns.guardedsuspension.sample.RequestQueue;

import java.util.Random;

/**
 * 接收请求的类
 * Active Object
 * 用于表示接收请求的线程
 * 持有RequestQueue的实例，使用getRequest方法接收请求
 * */
public class ServerThread extends Thread {
    private final Random random;

    // 持有RequestQueue的实例
    private final RequestQueue requestQueue;

    public ServerThread(RequestQueue requestQueue, String name, long seed) {
        super(name);
        this.requestQueue = requestQueue;
        this.random = new Random(seed);
    }

    public void run() {
        for (int i = 0; i < 10000; i++) {
            // 使用getRequest方法接收请求
            Request request = requestQueue.getRequest();

            System.out.println(Thread.currentThread().getName() + " handles  " + request);

            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException ignored) {
            }
        }
    }
}
