package com.chris.javabasics.patterns.singleton;

/**
 * 将单例对象与线程绑定的实现方式
 * 通过线程局部变量，每个线程都可以拥有自己的单例实例，从而实现线程安全的单例模式
 * <p>
 * 使用线程局部变量实现单例模式的优点包括：
 *      线程安全：每个线程都拥有自己的单例实例，不存在多线程竞争的问题，实现了线程安全性
 *      延迟初始化：每个线程在首次访问时才会创建实例，实现了延迟初始化的效果
 *      高效性能：通过将单例对象与线程绑定，避免了同步开销，提高了性能
 * <p>
 * 使用线程局部变量实现的单例模式适用于每个线程独立拥有自己的单例实例的场景
 * Java使用线程局部变量实现的单例模式是一种线程安全且延迟初始化的实现方式，适合于需要每个线程拥有独立单例实例的场景
 * */
public class ThreadLocalSingleton {

    // 使用ThreadLocal来存储每个线程的单例实例
    // 通过重写ThreadLocal的initialValue方法，可以在每个线程首次访问时创建并初始化单例实例
    private static final ThreadLocal<ThreadLocalSingleton> threadLocalInstance = ThreadLocal.withInitial(
            ThreadLocalSingleton::new
    );

    private ThreadLocalSingleton() {}

    public static ThreadLocalSingleton getInstance() {
        return threadLocalInstance.get();
    }
}
