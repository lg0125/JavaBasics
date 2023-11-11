package com.chris.javabasics.jucpatterns.balking.timeout;

import java.util.concurrent.TimeoutException;

/**
 * 使用wait方法来实现guarded timed
 * 超时异常使用TimeoutException
 * <p>
 * setExecutable方法用于修改状态
 * execute方法用于运行
 *      守护条件是"ready字段为true"
 *      execute方法经过timeout毫秒之后就会发生超时
 *      当发生超时，抛出TimeoutException异常
 * <p>
 * guarded timed/timeout
 * “在守护条件成立之前等待一段时间”
 * 在守护条件成立之前等待一段时间，如果到时条件还未成立，则直接balk
 * */
public class Host {
    private final long timeout; // 超时时间
    private boolean ready = false; // 方法正常执行时值为true

    public Host(long timeout) {
        this.timeout = timeout;
    }

    // 修改状态
    public synchronized void setExecutable(boolean on) {
        ready = on;
        notifyAll();
    }

    // 检查状态之后再执行
    public synchronized void execute() throws InterruptedException, TimeoutException {
        long start = System.currentTimeMillis(); // 开始时间
        while (!ready) {
            long now = System.currentTimeMillis(); // 当前时间
            long rest = timeout - (now - start); // 剩余的等待时间
            if (rest <= 0) {
                throw new TimeoutException("now - start = " + (now - start) + ", timeout = " + timeout);
            }
            wait(rest);
        }
        doExecute();
    }

    // 实际的处理
    private void doExecute() {
        System.out.println(Thread.currentThread().getName() + " calls doExecute");
    }
}
