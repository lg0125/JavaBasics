package com.chris.javabasics.jucpatterns.future.jucsample;

public class Host {
    public FutureData request(final int count, final char c) {
        System.out.println("    request(" + count + ", " + c + ") BEGIN");

        // (1) 创建FutureData的实例
        //     （向构造函数中传递 Callable<RealData>）
        // 创建Future类的实例时，Callable对象会被传递给构造函数
        FutureData future = new FutureData(
                // 该Callable对象的call方法的处理是"创建新的RealData的实例并返回给调用者"
                () -> new RealData(count, c)
        );

        // (2) 启动一个新线程，用于创建RealData的实例
        // 线程调用FutureTask的run方法，那么Callable对象的call方法将会被执行
        // 也就是说，调用FutureTask的run方法的线程也会调用call方法
        // 调用call方法的线程会同步地获取call方法的返回值，然后通过FutureTask的set方法来设置该返回值
        // 如果call方法中发生了异常，则调用call方法的线程就会调用FutureTask的setException方法设置异常
        //      启动的新线程会调用Callable的call方法，然后set返回值
        new Thread(future).start();

        System.out.println("    request(" + count + ", " + c + ") END");

        // (3) 返回FutureData的实例
        return future;
    }
}
