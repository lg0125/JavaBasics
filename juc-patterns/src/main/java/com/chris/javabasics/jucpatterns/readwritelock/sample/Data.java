package com.chris.javabasics.jucpatterns.readwritelock.sample;

import java.util.Arrays;

public class Data {
    // 实际的读写对象
    private final char[] buffer;

    // 该模式的主角ReadWriteLock的实例
    private final ReadWriteLock lock = new ReadWriteLock();

    public Data(int size) {
        this.buffer = new char[size];
        Arrays.fill(buffer, '*');
    }

    /**
     * read方法执行读取操作
     * 实际的读取操作是通过doRead方法执行的
     * 而doRead方法夹在lock.readLock()与lock.readUnlock()之间
     * <p>
     * lock.readLock()      获取读锁
     * lock.readUnlock()    释放读锁
     *      保护buffer字段
     * */
    public char[] read() throws InterruptedException {
        lock.readLock();
        try {
            return doRead();
        } finally {
            lock.readUnlock();
        }
    }

    public void write(char c) throws InterruptedException {
        lock.writeLock();
        try {
            doWrite(c);
        } finally {
            lock.writeUnlock();
        }
    }

    private char[] doRead() {
        char[] newbuf = new char[buffer.length];
        System.arraycopy(buffer, 0, newbuf, 0, buffer.length);
        slowly();
        return newbuf;
    }

    private void doWrite(char c) {
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = c;
            slowly();
        }
    }

    private void slowly() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException ignored) {
        }
    }
}
