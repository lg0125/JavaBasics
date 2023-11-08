package com.chris.javabasics.jucpatterns.singlethreadedexecution.semaphore;

import java.util.Random;

public class UserThread implements Runnable {
    private final static Random random = new Random(26535);
    private final BoundedResource resource;

    public UserThread(BoundedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        try {
            while (true) {
                resource.use();
                Thread.sleep(random.nextInt(3000));
            }
        } catch (InterruptedException ignored) {
        }
    }
}
