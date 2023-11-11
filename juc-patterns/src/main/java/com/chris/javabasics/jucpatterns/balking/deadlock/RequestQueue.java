package com.chris.javabasics.jucpatterns.balking.deadlock;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 使用超时检查死锁(生存性不足)
 * 当经过30s守护条件还未成立时，则抛出LivenessException异常
 * <p>
 * 生存性不足——运行时稳定，无法恢复的状态
 * <p>
 * 如果某些处理造成的异常状态可以恢复，则使用Exception的子类来表示这些异常状态
 *      解决异常状态的代码则写在catch语句块里
 * 如果某些处理造成的异常状态无法恢复，则使用RuntimeException的子类来表示这些异常状态
 * */
public class RequestQueue {
    private final BlockingQueue<Request> queue = new LinkedBlockingQueue<>();

    public Request getRequest() {
        Request req = null;

        try {
            // LinkedBlockingQueue提供处理超时的方法
            req = queue.poll(30L, TimeUnit.SECONDS);

            if (req == null)
                throw new LivenessException("thrown by " + Thread.currentThread().getName());
        } catch (InterruptedException ignored) {
        }

        return req;
    }
    public void putRequest(Request request) {
        try {
            boolean offered = queue.offer(request, 30L, TimeUnit.SECONDS);

            if (!offered)
                throw new LivenessException("thrown by " + Thread.currentThread().getName());
        } catch (InterruptedException ignored) {
        }
    }
}
