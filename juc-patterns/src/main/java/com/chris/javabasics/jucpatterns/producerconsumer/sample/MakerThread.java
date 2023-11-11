package com.chris.javabasics.jucpatterns.producerconsumer.sample;

import java.util.Random;

/**
 * 用于制作蛋糕，并将其放置到桌子上，即糕点师
 * <p>
 * 无限循环执行"制作蛋糕->放置到桌子上"，是蛋糕的生产者
 * */
public class MakerThread extends Thread {
    private final Random random;

    private final Table table;

    // 蛋糕的流水号(所有糕点师共用)，故声明为静态字段
    private static int id = 0;

    public MakerThread(String name, Table table, long seed) {
        super(name);
        this.table = table;
        this.random = new Random(seed);
    }

    public void run() {
        try {
            while (true) {
                Thread.sleep(random.nextInt(1000));
                String cake = "[ Cake No." + nextId() + " by " + getName() + " ]";

                table.put(cake);
            }
        } catch (InterruptedException ignored) {
        }
    }

    private static synchronized int nextId() {
        return id++;
    }
}
