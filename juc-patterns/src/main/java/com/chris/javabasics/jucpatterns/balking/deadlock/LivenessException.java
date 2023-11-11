package com.chris.javabasics.jucpatterns.balking.deadlock;

public class LivenessException extends RuntimeException {
    public LivenessException(String msg) {
        super(msg);
    }
}
