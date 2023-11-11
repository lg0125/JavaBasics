package com.chris.javabasics.jucpatterns.future.sample;

/**
 * 向请求返回FutureData的实例的类
 * */
public class Host {
    public Data request(final int count, final char c) {
        System.out.println("    request(" + count + ", " + c + ") BEGIN");

        // (1) 创建FutureData的实例
        // 并不会耗费很长时间，该实例会被作为返回值返回给调用者
        final FutureData future = new FutureData();

        // (2) 启动一个新线程，用于创建RealData的实例
        // 创建RealData类的实例需要花费很长世间，但这是在新进程中进行的，并不影响Main线程的处理
        new Thread(() -> {
            // 新线程会努力地创建RealData的实例realData
            RealData realdata = new RealData(count, c);
            // 当realData创建完成后，使用setRealData方法将其设置到future字段中
            future.setRealData(realdata);
        }).start();

        System.out.println("    request(" + count + ", " + c + ") END");

        // (3) 返回FutureData的实例
        return future;
    }
}
