package com.chris.javabasics.problems.print100.v1;

public class Print100 {
    private static final int MAX_NUMBER = 100;

    private static volatile int number = 0;

    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread threadOdd = new Thread(() -> {
            while (number <= MAX_NUMBER) {
                synchronized (lock) {
                    if (number % 2 == 1) {
                        System.out.println(number);
                        number++;
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread threadEven = new Thread(() -> {
            while (number <= MAX_NUMBER) {
                synchronized (lock) {
                    if (number % 2 == 0) {
                        System.out.println(number);
                        number++;
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        threadOdd.start();
        threadEven.start();
    }
}
