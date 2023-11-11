package com.chris.javabasics.jucpatterns.threadpool.sample;

/**
 * worker thread会逐个取回工作并进行处理
 * 当工作完成后，工人线程会等待新的工作到来
 * 所有工人线程都在等待工作请求的到来
 * 工作请求到来之后，工人线程会从channel获取一项工作请求并开始工作
 * 工作完成后，工人线程会回到Channel等待下一项工作请求
 * */
public class WorkerThread extends Thread {
    private final Channel channel;

    private volatile boolean terminated = false;

    public WorkerThread(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    public void run() {
        try {
            while (!terminated) {
                try {
                    Request request = channel.takeRequest();
                    request.execute();
                } catch (InterruptedException e) {
                    terminated = true;
                }
            }
        } finally {
            System.out.println(Thread.currentThread().getName() + " is terminated.");
        }
    }

    public void stopThread() {
        terminated = true;
        interrupt();
    }
}
