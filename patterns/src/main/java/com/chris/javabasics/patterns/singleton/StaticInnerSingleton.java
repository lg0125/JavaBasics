package com.chris.javabasics.patterns.singleton;

// 一种利用静态内部类的特性来实现延迟初始化和线程安全的单例模式
// 优点是实现简单，线程安全，并且实现了延迟初始化
// 利用了Java类加载机制和静态内部类的特性，避免了显式的同步操作和双重检查锁的复杂性
// 同时，它也提供了较好的性能，因为只有在需要获取单例对象时才会加载静态内部类
public class StaticInnerSingleton {
    // 将构造函数声明为私有，以防止外部直接实例化对象
    private StaticInnerSingleton() {}

    // 定义了一个私有的静态内部类SingletonHolder，它包含一个静态成员变量instance，用于持有单例对象
    // 由于静态内部类只有在被使用时才会被加载，且加载过程是线程安全的，
    //      因此，可以保证在多线程环境下只有一个线程会加载并初始化SingletonHolder类
    //      这样，可以确保instance成员变量只被实例化一次，从而实现了延迟初始化和线程安全

    private static class SingletonHolder {
        private static final StaticInnerSingleton instance = new StaticInnerSingleton();
    }

    // 在getInstance()方法中，直接返回SingletonHolder.instance，这样可以获取到单例对象
    public static StaticInnerSingleton getInstance() {
        return SingletonHolder.instance;
    }
}
