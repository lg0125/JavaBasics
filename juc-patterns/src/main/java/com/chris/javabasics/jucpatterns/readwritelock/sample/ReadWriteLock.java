package com.chris.javabasics.jucpatterns.readwritelock.sample;

/**
 * 当线程"读取"实例的状态时，实例的状态不会发生变化，实例的状态仅在线程执行"写入"操作时才会发生变化
 * <p>
 * Read-Write Lock模式
 * 在执行读取操作之前，线程必须获取用于读取的锁
 * 在执行写入操作之前，线程必须获取用于写入的锁
 * <p>
 * 当线程执行读取操作时，实例的状态不会发生变化
 *      多个线程可以同时读取
 *      但在读取时，不可以写入
 * 当线程执行写入操作时，实例的状态就会发生变化
 *      当有一个线程正在写入时，其他线程不可以读取或写入
 *
 * Before/After模式
 *      before();
 *      try {
 *          execute();
 *      } finally {
 *          after();
 *      }
 * before放在try外面，表示
 *      如果在执行before的过程中发生异常，execute不会执行，则after也不会执行
 * */
public final class ReadWriteLock {

    /**
     * 执行了readLock，但尚未执行readUnlock的线程个数
     * readingReaders的值一定大于0
     * */
    private int readingReaders = 0; // (A)…实际正在读取中的线程个数

    /**
     * 执行到writeLock之后，使用wait执行等待的线程的个数
     * */
    private int waitingWriters = 0; // (B)…正在等待写入的线程个数

    /**
     * 执行了writeLock，但尚未执行writeUnlock的线程的个数
     * writingWriters的值只能是0或1
     * */
    private int writingWriters = 0; // (C)…实际正在写入中的线程个数

    /**
     * 值为true，表示写入优先，值为false，表示读取优先
     * 用来确定ReaderThread和WriterThread哪一个更优先的标志
     * 只要值为true，就要检查守护条件的waitingWriters
     * read操作终止后优先执行write操作，write操作终止后优先执行read操作
     * preferWriter字段用来让ReaderThread和WriterThread轮流优先执行
     * */
    private boolean preferWriter = true; // 若写入优先，则为true

    /**
     * waitingWriters字段用于保存正在wait的WriterThread的个数
     * 当waitingWriters大于0时，通过让ReaderThread线程wait，就可以防止WriterThread无法开始执行的情况发生
     * */
    public synchronized void readLock() throws InterruptedException {
        // Guarded Suspension模式

        // 守护条件——writingWriters <= 0，即没有线程正在执行写入操作
        while (writingWriters > 0 || (preferWriter && waitingWriters > 0))
            wait();

        readingReaders++;                       // (A) 实际正在读取的线程个数加1
    }

    public synchronized void readUnlock() {
        readingReaders--;                       // (A) 实际正在读取的线程个数减1
        preferWriter = true;

        notifyAll();
    }

    public synchronized void writeLock() throws InterruptedException {
        waitingWriters++;                       // (B) 正在等待写入的线程个数加1
        try {
            // Guarded Suspension模式
            // 守护条件——readingReaders <= 0 && writingWriters <= 0，即没有线程正在执行读取或写入操作
            while (readingReaders > 0 || writingWriters > 0)
                wait();
        } finally {
            waitingWriters--;                   // (B) 正在等待写入的线程个数减1
        }

        writingWriters++;                       // (C) 实际正在写入的线程个数加1
    }

    public synchronized void writeUnlock() {
        writingWriters--;                       // (C) 实际正在写入的线程个数减1
        preferWriter = false;

        notifyAll();
    }
}
