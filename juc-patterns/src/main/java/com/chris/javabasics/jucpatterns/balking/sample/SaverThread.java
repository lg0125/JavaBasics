package com.chris.javabasics.jucpatterns.balking.sample;

import java.io.IOException;

/**
 * 用于定期保存数据内容
 * */
public class SaverThread extends Thread {
    private final Data data;

    public SaverThread(String name, Data data) {
        super(name);
        this.data = data;
    }

    /**
     * 每隔1000毫秒，就调用一次Data实例的save方法
     * */
    public void run() {
        try {
            while (true) {
                data.save();            // 要求保存数据
                Thread.sleep(1000);     // 休眠约1秒
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
