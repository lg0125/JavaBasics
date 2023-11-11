package com.chris.javabasics.jucpatterns.guardedsuspension.jucsample;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class RequestQueue {
    /**
     * LinkedBlockingQueue类使用Guarded Suspension模式，能够保证线程安全
     * 因此，getRequest和putRequest方法无需声明为synchronized方法
     * */
    private final BlockingQueue<Request> queue = new LinkedBlockingQueue<>();

    public Request getRequest() {
        Request req = null;

        try {
            req = queue.take();
        } catch (InterruptedException ignored) {
        }
        return req;
    }

    public void putRequest(Request request) {
        try {
            queue.put(request);
        } catch (InterruptedException ignored) {
        }
    }
}
