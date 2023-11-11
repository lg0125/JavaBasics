package com.chris.javabasics.jucpatterns.producerconsumer.sample;

public class Table {
    // 用于表示蛋糕的实际放置位置
    private final String[] buffer;

    private int tail;  // 下次put的位置

    private int head;  // 下次take的位置

    private int count; // buffer中的蛋糕个数

    public Table(int count) {
        this.buffer = new String[count];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    /**
     * throws InterruptedException 该方法可以取消
     * <p>
     * 放置蛋糕
     * <p>
     * put方法使用Guarded Suspension模式
     * 守护条件为while条件表达式的逻辑非运算 count < buffer.length
     * 即守护条件为"还有可以放置蛋糕的位置"
     * */
    public synchronized void put(String cake) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " puts " + cake);

        while (count >= buffer.length)
            wait();

        buffer[tail] = cake;
        tail = (tail + 1) % buffer.length;
        count++;
        notifyAll();
    }

    /**
     * throws InterruptedException 该方法可以取消
     * <p>
     * 取蛋糕
     * <p>
     * take方法使用Guarded Suspension模式
     * 守护条件为while条件表达式的逻辑非运算 count > 0
     * 即守护条件为"至少有一个蛋糕"
     * */
    public synchronized void take() throws InterruptedException {
        while (count <= 0)
            wait();

        String cake = buffer[head];
        head = (head + 1) % buffer.length;
        count--;
        notifyAll();

        System.out.println(Thread.currentThread().getName() + " takes " + cake);
    }
}
