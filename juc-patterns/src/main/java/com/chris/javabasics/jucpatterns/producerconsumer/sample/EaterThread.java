package com.chris.javabasics.jucpatterns.producerconsumer.sample;

import java.util.Random;

/**
 * 用于表示从桌子上取蛋糕吃的客人
 * 无限循环执行"从桌子上取蛋糕->吃蛋糕"，屎蛋糕的消费者
 * */
public class EaterThread extends Thread {
    private final Random random;

    private final Table table;

    public EaterThread(String name, Table table, long seed) {
        super(name);
        this.table = table;
        this.random = new Random(seed);
    }

    public void run() {
        try {
            while (true) {
                table.take();

                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException ignored) {
        }
    }
}
