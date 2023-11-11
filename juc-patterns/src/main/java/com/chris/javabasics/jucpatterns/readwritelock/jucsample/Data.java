package com.chris.javabasics.jucpatterns.readwritelock.jucsample;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * JUC的ReadWriteLock接口和ReentrantReadWriteLock实现类
 *
 * ReentrantReadWriteLock类
 *  公平性
 *      创建ReentrantReadWriteLock类的实例时，可以选择锁的获取顺序是否要设为公平(fair)
 *  可重入性
 *      Reader角色的线程也可以获取写锁
 *      Writer角色的线程也可以获取读锁
 *  锁降级
 *      可以按如下顺序将写锁降级为读锁
 *          获取写锁
 *          获取读锁
 *          释放写锁
 *      但是，读锁不能升级为写锁
 * */
public class Data {
    private final char[] buffer;

    private final ReadWriteLock lock = new ReentrantReadWriteLock(true);

    private final Lock readLock = lock.readLock();

    private final Lock writeLock = lock.writeLock();

    public Data(int size) {
        this.buffer = new char[size];
        Arrays.fill(buffer, '*');
    }
    public char[] read() throws InterruptedException {
        readLock.lock();
        try {
            return doRead();
        } finally {
            readLock.unlock();
        }
    }
    public void write(char c) throws InterruptedException {
        writeLock.lock();
        try {
            doWrite(c);
        } finally {
            writeLock.unlock();
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
