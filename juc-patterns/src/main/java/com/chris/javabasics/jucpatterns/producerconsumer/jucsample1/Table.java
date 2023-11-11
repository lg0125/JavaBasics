package com.chris.javabasics.jucpatterns.producerconsumer.jucsample1;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * BlockingQueue接口及其实现类
 *      相当于Channel角色
 * BlockingQueue接口表示的是
 *      在达到合适的状态之前线程一直阻塞(wait)的队列
 * 实现阻塞功能的方法是put方法和take方法
 * */
public class Table extends ArrayBlockingQueue<String> {

    public Table(int count) {
        super(count);
    }

    @Override
    public void put(String cake) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " puts " + cake);
        super.put(cake);
    }

    @Override
    public String take() throws InterruptedException {
        String cake = super.take();
        System.out.println(Thread.currentThread().getName() + " takes " + cake);
        return cake;
    }
}
