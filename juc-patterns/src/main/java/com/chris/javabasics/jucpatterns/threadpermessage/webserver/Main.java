package com.chris.javabasics.jucpatterns.threadpermessage.webserver;

public class Main {
    public static void main(String[] args) {
        new MiniServer(8888).execute();
    }
}
