package com.chris.javabasics.jucpatterns.balking.sample;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;


/**
 * Balking模式
 * 如果现在不适合执行这个操作，或者没必要执行这个操作，就停止处理，直接返回
 * Balking模式也存在守护模式——如果守护模式不成立，则立即中断
 * <p>
 * 表示可以修改并保存的数据的类
 * <p>
 * 当数据内容被写入时，会完全覆盖上次写入的内容，只有最新的内容才会被保存
 * 当写入的内容与上次写入的内容完全相同时，就不会执行写入操作(Balking)
 * 以"数据内容存在不同"作为守护条件
 * 如果数据内容相同，则不会执行写入操作，直接返回(balk)
 * */
public class Data {
    private final String filename;  // 保存的文件名称
    private String content;         // 数据内容

    /**
     * changed的值为true时，表示进行了修改，
     * 而为false时，则表示未修改过
     * 根据changed的值决定要不要执行文件写入
     * "changed的值为true"是守护条件
     * */
    private boolean changed;        // 修改后的内容若未保存，则为true

    public Data(String filename, String content) {
        this.filename = filename;
        this.content = content;
        this.changed = true;
    }

    /*
    * change和save方法都是synchronized方法
    * synchronized关键字保护的是content字段和changed字段
    *
    *
    * */

    // 修改数据内容
    public synchronized void change(String newContent) {
        content = newContent;
        changed = true;
    }

    /**
     * 若数据内容修改过，则保存到文件中
     * <p>
     * 先检查changed标志的值
     *      如果changed标志为false，表明数据内容并未修改过，则立即返回(balk)
     *      如果changed标志为true，则调用doSave方法，执行文件写入操作，将changed标志设置为false
     *
     *
     */
    public synchronized void save() throws IOException {

        if (!changed) {
            return;
        }
        doSave();
        changed = false;
    }

    // 将数据内容实际保存到文件中
    private void doSave() throws IOException {
        System.out.println(Thread.currentThread().getName() + " calls doSave, content = " + content);
        Writer writer = new FileWriter(filename);
        writer.write(content);
        writer.close();
    }
}
