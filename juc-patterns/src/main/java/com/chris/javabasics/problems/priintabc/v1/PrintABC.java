package com.chris.javabasics.problems.priintabc.v1;

import java.util.concurrent.Semaphore;

public class PrintABC {
    private static final int PRINT_COUNT = 10;

    // 三个Semaphore对象semaphoreA、semaphoreB和semaphoreC，分别表示字母A、B和C的信号量

    private static final Semaphore semaphoreA = new Semaphore(1);

    private static final Semaphore semaphoreB = new Semaphore(0);

    private static final Semaphore semaphoreC = new Semaphore(0);


    public static void main(String[] args) {
        // 创建字符A、B和C三个线程，并分别传入相应的信号量对象
        // 然后启动这三个线程
        // 线程会循环打印字符ABC，直到达到指定的循环次数
        Thread threadA = new Thread(() -> print("A", semaphoreA, semaphoreB));
        Thread threadB = new Thread(() -> print("B", semaphoreB, semaphoreC));
        Thread threadC = new Thread(() -> print("C", semaphoreC, semaphoreA));

        threadA.start();
        threadB.start();
        threadC.start();
    }

    private static void print(String letter, Semaphore currentSemaphore, Semaphore nextSemaphore) {
        for (int i = 0; i < PRINT_COUNT; i++) {
            try {
                // currentSemaphore.acquire()获取当前线程的信号量许可，
                // 如果没有许可则线程会进入阻塞状态
                currentSemaphore.acquire();

                System.out.println(letter);

                // 通过nextSemaphore.release()释放下一个线程的信号量许可，
                // 使下一个线程可以继续执行
                nextSemaphore.release();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
