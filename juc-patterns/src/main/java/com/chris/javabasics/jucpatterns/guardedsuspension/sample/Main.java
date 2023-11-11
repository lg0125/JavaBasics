package com.chris.javabasics.jucpatterns.guardedsuspension.sample;

/**
 * Guarded Suspension模式
 * 如果执行现在的处理会造成问题，就让执行处理的线程进行等待
 * */
public class Main {
    public static void main(String[] args) {
        RequestQueue requestQueue = new RequestQueue();
        new ClientThread(requestQueue, "Alice", 3141592L).start();
        new ServerThread(requestQueue, "Bobby", 6535897L).start();
    }
}
