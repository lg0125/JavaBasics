package com.chris.javabasics.jucpatterns.future.jucsample;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Callable接口
 *      类似于Runnable接口
 *      将"返回值的某种处理的调用"抽象化
 *      接口声明了call方法，该方法有返回值
 * Future接口
 *      相当于Future角色
 *      Future接口声明了用于获取值得get方法，但并没有声明设置值的方法
 *      设置值的方法需要在实现Future接口的类中声明
 * FutureTask类
 *      Future接口、Runnable接口的实现类
 *      声明了用于获取值得get方法、用于中断运行的cancel方法、用于设置值的set方法
 *      用于设置异常的setException方法
 * */
public class FutureData
        extends FutureTask<RealData>
        implements Data {

    // 构造函数接收到的Callable对象会被直接传递给父类FutureTask
    // call方法的调用被交给了FutureTask类
    public FutureData(Callable<RealData> callable) {
        super(callable);
    }

    public String getContent() {
        String string = null;

        try {
            // 调用 FutureTask的get方法，就可以获取call方法的返回值
            // 其中，get方法无论由哪个线程调用都可以
            // 返回值是RealData类型
            // get方法是一个可以获取处理结果的线程安全的方法
            // 当发生中断时，get方法会抛出InterruptedException异常
            // 当call方法在运行时发生异常时，get方法会抛出ExecutionException异常
            string = get().getContent();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return string;
    }
}
