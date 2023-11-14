package com.chris.javabasics.patterns.singleton;

/**
 * 旨在实现延迟初始化的单例，并提供高效的线程安全性
 *
 * 使用双重检查锁的优点包括：
 *      延迟初始化：只有在需要时才进行实例化，实现了延迟初始化的效果
 *      高效性能：通过双重检查，减少了不必要的同步开销，提高了性能
 *      线程安全：在多线程环境下，通过同步块和volatile关键字的使用，保证了线程安全性
 * */
public class DoubleCheckedSingleton {
    // 将instance声明为volatile，确保多线程环境下的可见性，避免指令重排序带来的问题
    private static volatile DoubleCheckedSingleton instance;

    private DoubleCheckedSingleton() {}


    public static DoubleCheckedSingleton getInstance() {
        if (instance == null) { // 首先检查instance是否已经被实例化，如果没有则进入同步块
            // 通过synchronized关键字对Singleton.class进行同步，确保只有一个线程可以进入同步块内部进行实例化操作
            synchronized (DoubleCheckedSingleton.class) {
                if (instance == null) { // 在同步块内部再次检查instance是否为null，以防止在多线程环境下出现多次实例化的情况
                    instance = new DoubleCheckedSingleton();
                }
            }
        }
        return instance;
    }
}
