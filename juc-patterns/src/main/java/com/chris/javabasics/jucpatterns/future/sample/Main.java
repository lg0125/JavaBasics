package com.chris.javabasics.jucpatterns.future.sample;

/**
 * 向Host发出请求并获取数据的类
 * */
public class Main {
    public static void main(String[] args) {
        System.out.println("main BEGIN");
        Host host = new Host();

        // Future模式中，程序一旦发出请求，就会立即获取返回值
        // 这里的返回值data并非请求的运行结果，为了获得请求的运行结果，刚刚启动了其他线程去计算
        // 也就是说，这个返回值并不是蛋糕本身，而是蛋糕的提货单(Future角色)
        // 1. 调用request方法三次，接收三个Data作为返回值
        //      这三个返回值实际上是FutureData类的实例，无需花费时间即可得到，相当于获取了三张提货单
        // 调用request方法的线程(主线程)会在新线程启动后拿到返回值future并立即返回
        Data data1 = host.request(10, 'A');
        Data data2 = host.request(20, 'B');
        Data data3 = host.request(30, 'C');

        // 2. 表示去执行了其他操作
        System.out.println("main otherJob BEGIN");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ignored) {
        }
        System.out.println("main otherJob END");

        // 过一段时间后，线程会调用data的getContent方法来获取运行结果
        // 如果其他线程处理完了请求，那么调用getContent的线程会立即从该方法返回；
        // 如果其他线程还没有处理完请求，那么调用getContent的线程则会继续等待运行结果·
        // 3. 调用getContent方法来获取真正希望获取的结果(request方法的处理结果)，相当于使用提货单提取蛋糕
        System.out.println("data1 = " + data1.getContent());
        System.out.println("data2 = " + data2.getContent());
        System.out.println("data3 = " + data3.getContent());
        System.out.println("main END");
    }
}
