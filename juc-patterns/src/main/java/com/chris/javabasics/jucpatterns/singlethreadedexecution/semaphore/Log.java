package com.chris.javabasics.jucpatterns.singlethreadedexecution.semaphore;

public class Log {
    public static void println(String s) {
        System.out.println(Thread.currentThread().getName() + ": " + s);
    }
}
