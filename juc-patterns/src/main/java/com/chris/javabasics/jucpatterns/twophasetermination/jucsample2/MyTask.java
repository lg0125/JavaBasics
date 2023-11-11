package com.chris.javabasics.jucpatterns.twophasetermination.jucsample2;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class MyTask implements Runnable {
    private static final int PHASE = 5;

    /**
     * CycleBarrier可以周期性地cyclic创建出屏障barrier
     * 在屏障接触之前，碰到屏障的线程是无法继续前进的
     * 屏障的解除条件是到达屏障处的线程个数达到构造函数指定的个数
     *      也就是说，当指定个数的线程到达屏障后，屏障就会被解除
     * 为了使线程能在这五个阶段中保持"步调一致"，这需要使用CyclicBarrier类
     * */
    private final CyclicBarrier phaseBarrier;

    // 为了通知主线程"所有工作的各个阶段都已经结束"，使用CountDownLatch类
    private final CountDownLatch doneLatch;

    private final int context;

    private static final Random random = new Random(314159);

    public MyTask(CyclicBarrier phaseBarrier, CountDownLatch doneLatch, int context) {
        this.phaseBarrier = phaseBarrier;
        this.doneLatch = doneLatch;
        this.context = context;
    }

    @Override
    public void run() {
        try {
            for (int phase = 0; phase < PHASE; phase++) {
                // 1. 调用doPhase(phase)方法进行第phase阶段的工作
                doPhase(phase);
                // 2. 调用await方法表明自己已经完成了第phase阶段的工作
                // 3. 当其他所有线程都完成第phase阶段的工作后，从await方法中返回并进入下一阶段的工作
                phaseBarrier.await();
            }
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        } finally {
            // 当所有阶段的工作都完成后，使用doneLatch向主线程发送"工作结束"的消息
            doneLatch.countDown();
        }
    }

    protected void doPhase(int phase) {
        String name = Thread.currentThread().getName();
        System.out.println(name + ":MyTask:BEGIN:context = " + context + ", phase = " + phase);
        try {
            Thread.sleep(random.nextInt(3000));
        } catch (InterruptedException ignored) {
        } finally {
            System.out.println(name + ":MyTask:END:context = " + context + ", phase = " + phase);
        }
    }
}
