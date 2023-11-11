package com.chris.javabasics.jucpatterns.guardedsuspension.sample;

import java.util.Random;

/**
 * 发送请求的类
 * Active Object
 * 用于表示发送请求的线程
 * 持有RequestQueue的实例，并连续调用该实例的putRequest方法，放入请求
 * */
public class ClientThread extends Thread {
    private final Random random;

    // 持有RequestQueue的实例
    private final RequestQueue requestQueue;

    public ClientThread(RequestQueue requestQueue, String name, long seed) {
        super(name);
        this.requestQueue = requestQueue;
        this.random = new Random(seed);
    }

    public void run() {
        for (int i = 0; i < 10000; i++) {
            Request request = new Request("No." + i);
            System.out.println(Thread.currentThread().getName() + " requests " + request);

            // 连续调用该实例的putRequest方法，放入请求
            requestQueue.putRequest(request);

            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException ignored) {
            }
        }
    }
}
