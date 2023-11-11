package com.chris.javabasics.jucpatterns.balking.sample;

import java.io.IOException;
import java.util.Random;

/**
 * 用于修改数据内容，并执行保存处理
 *
 * 启动的线程以字符串作为参数，循环调用change方法来修改数据
 * 每修改完一个数据，使用sleep方法随机暂停一段时间，然后调用save方法保存数据
 * (表示 将刚才修改的数据反映到文件中)
 *
 * */
public class ChangerThread extends Thread {
    private final Data data;

    private final Random random = new Random();

    public ChangerThread(String name, Data data) {
        super(name);
        this.data = data;
    }

    public void run() {
        try {
            for (int i = 0; true; i++) {
                data.change("No." + i);             // 修改数据
                Thread.sleep(random.nextInt(1000)); // 执行其他操作
                data.save();                        // 显式地保存
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
