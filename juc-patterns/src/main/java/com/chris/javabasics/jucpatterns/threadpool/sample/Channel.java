package com.chris.javabasics.jucpatterns.threadpool.sample;

/**
 * 接收工作请求并将工作请求交给工人线程的类
 *
 * */
public class Channel {
    private static final int MAX_REQUEST = 100;


    private final Request[] requestQueue; // 保存请求的队列

    private int tail;  // 下次putRequest的位置

    private int head;  // 下次takeRequest的位置

    private int count; // Request的数量

    private final WorkerThread[] threadPool; //保存工人线程的数组

    public Channel(int threads) {
        this.requestQueue = new Request[MAX_REQUEST];
        this.head = 0;
        this.tail = 0;
        this.count = 0;

        // 初始化threadPool并创建工人线程的实例
        threadPool = new WorkerThread[threads];
        for (int i = 0; i < threadPool.length; i++)
            threadPool[i] = new WorkerThread(
                    "Worker-" + i,
                    this
            );
    }

    public void startWorkers() {
        // 启动所有工人线程
        for (WorkerThread workerThread : threadPool)
            workerThread.start();
    }

    public void stopAllWorkers() {
        for (WorkerThread workerThread : threadPool)
            workerThread.stopThread();
    }

    // 用于将请求放入到队列中
    public synchronized void putRequest(Request request) {
        // Guarded Suspension模式
        while (count >= requestQueue.length) {
            try {
                wait();
            } catch (InterruptedException ignored) {
            }
        }

        // producer(Producer-Consumer模式)
        requestQueue[tail] = request;
        tail = (tail + 1) % requestQueue.length;
        count++;

        notifyAll();
    }

    // 用于取出队列中的请求
    public synchronized Request takeRequest() {
        // Guarded Suspension模式
        while (count <= 0) {
            try {
                wait();
            } catch (InterruptedException ignored) {
            }
        }

        // consumer(Producer-Consumer模式)
        Request request = requestQueue[head];
        head = (head + 1) % requestQueue.length;
        count--;

        notifyAll();

        return request;
    }
}
