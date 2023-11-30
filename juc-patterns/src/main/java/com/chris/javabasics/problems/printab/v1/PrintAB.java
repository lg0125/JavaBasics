package com.chris.javabasics.problems.printab.v1;

public class PrintAB {
    private static final Object lock = new Object();
    private static boolean printA = true;

    private static final int MAX_COUNT = 10;

    public static void main(String[] args) {
        // 在每次循环中，通过判断当前线程要打印的字母和printA的值来确定是否可以打印
        //      如果当前线程要打印的是字母A并且printA为false，或者当前线程要打印的是字母B并且printA为true，
        //      则当前线程进入等待状态，释放锁，并等待其他线程的唤醒
        // 如果当前线程可以打印，输出当前字母，并将printA取反，然后通过lock.notifyAll()唤醒其他等待的线程

        Thread threadA = new Thread(() -> {
            for (int i = 0; i < MAX_COUNT; i++) {
                // 使用synchronized关键字锁定lock对象，确保每个线程在访问共享资源前都进入互斥状态
                synchronized (lock) {
                    while (!printA) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("A");
                    printA = false;
                    lock.notify();
                }
            }
        });

        Thread threadB = new Thread(() -> {
            for (int i = 0; i < MAX_COUNT; i++) {
                // 使用synchronized关键字锁定lock对象，确保每个线程在访问共享资源前都进入互斥状态
                synchronized (lock) {
                    while (printA) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("B");
                    printA = true;
                    lock.notify();
                }
            }
        });

        threadA.start();
        threadB.start();
    }
}
