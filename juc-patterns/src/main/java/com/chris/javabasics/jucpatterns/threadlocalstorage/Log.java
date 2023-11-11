package com.chris.javabasics.jucpatterns.threadlocalstorage;

public class Log {
    /**
     * ThreadLocal的实例当作一个集合，即一个ThreadLocal实例管理多个对象
     * ThreadLocal的实例看作一个有着多个储物柜的储物间
     * <p>
     * set方法——存储
     *      用于将通过参数接收的实例与调用该方法的线程(当前线程)对应并存储起来
     *      存储的对象可以通过get方法获取
     *      set方法中没有表示线程的参数，先查询当前线程，然后以它为key来存储实例
     *      调用set方法相当于将自己的行李放置到自己的储物柜
     * <p>
     * get方法——获取
     *      用于获取与调用get方法的线程(当前线程)对应的实例
     *      该线程之前通过set方法存储的实例就是get方法的返回值
     *      如果之前一次都没有调用过set方法，则get方法的返回值为null
     *      get方法中没有表示线程的参数，以当初线程作为key去获取对象
     *
     * ThreadLocal的实例tsLogCollection——保存各个线程的ThreadSpecificLog实例的储物间
     * */
    private static final ThreadLocal<ThreadSpecificLog> tsLogCollection = new ThreadLocal<>();

    // 写日志
    public static void println(String s) {
        getTSLog().println(s);
    }

    // 关闭日志
    public static void close() {
        getTSLog().close();
    }

    // 获取线程特有的日志
    private static ThreadSpecificLog getTSLog() {
        ThreadSpecificLog tsLog = tsLogCollection.get();

        // 如果该线程是第一次调用本方法，就新生成并注册一个日志
        if (tsLog == null) {
            tsLog = new ThreadSpecificLog(Thread.currentThread().getName() + "-log.txt");
            tsLogCollection.set(tsLog);
        }

        return tsLog;
    }
}
