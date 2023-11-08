package com.chris.javabasics.jucpatterns.immutable.jucsample;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) {
        final List<Integer> list = new CopyOnWriteArrayList<>();

        new WriterThread(list).start();
        new ReaderThread(list).start();
    }
}
