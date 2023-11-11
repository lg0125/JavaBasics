package com.chris.javabasics.jucpatterns.twophasetermination.sample;

public class CountupThread extends Thread {
    // 计数值
    private long counter = 0;

    // 发出终止请求后变为true
    // 表示是否已经发出终止请求的标志
    // 用于判断线程是否要进入"终止处理中"的状态
    private volatile boolean shutdownRequested = false;

    // 终止请求
    // 当要终止CountupThread的线程时，程序会调用该方法
    // 无需声明为synchronized方法
    //      shutdownRequested标志是一个一旦被设置为true后就不会再变为false的闭锁Latch
    // 即使被多个线程同时调用也不会有问题(不存在数据竞争)
    public void shutdownRequest() {
        shutdownRequested = true;
        // 调用interrupt方法，确保线程在sleep和wait时也会被终止
        interrupt();
    }

    // 检查是否发出了终止请求
    // 即检查shutdownRequest方法是否已经被调用
    public boolean isShutdownRequested() {
        return shutdownRequested;
    }

    // 线程体
    @Override
    public final void run() {
        try {
            while (!isShutdownRequested()) {
                doWork();
            }
        } catch (InterruptedException ignored) {
        } finally {
            doShutdown();
        }
    }

    // 操作
    private void doWork() throws InterruptedException {
        counter++;
        System.out.println("doWork: counter = " + counter);
        Thread.sleep(500);
    }

    // 终止处理
    private void doShutdown() {
        System.out.println("doShutdown: counter = " + counter);
    }
}
