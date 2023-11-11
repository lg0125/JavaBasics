package com.chris.javabasics.jucpatterns.balking.sample;

/**
 * 首先会创建一个Data实例，然后ChangerThread和SaveThread的实例会共用该实例，分别启动各自的线程
 * content字段的内容都不是重复保存的(没有重复的编号)
 * 这是因为当content内容相同时，线程就会balk，不再调用doSave方法
 * */
public class Main {
    public static void main(String[] args) {
        Data data = new Data("data.txt", "(empty)");
        new ChangerThread("ChangerThread", data).start();
        new SaverThread("SaverThread", data).start();
    }
}
