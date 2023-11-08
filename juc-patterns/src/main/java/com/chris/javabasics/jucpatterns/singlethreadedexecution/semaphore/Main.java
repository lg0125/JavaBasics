package com.chris.javabasics.jucpatterns.singlethreadedexecution.semaphore;

public class Main {
    public static void main(String[] args) {
        // 设置3个资源
        BoundedResource resource = new BoundedResource(3);

        // 10个线程使用资源
        // 10个线程交替使用资源，但同时可以使用的资源最多只能是3个
        for (int i = 0; i < 10; i++) {
            new Thread(new UserThread(resource)).start();
        }
    }
}
