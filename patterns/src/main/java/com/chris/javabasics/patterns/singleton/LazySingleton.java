package com.chris.javabasics.patterns.singleton;

/**
 * 一种延迟初始化的单例实现方式
 * 懒汉式单例模式在需要时才创建单例对象，而不是在类加载时就创建对象
 * <p>
 * 为了改善性能，可以使用双重检查锁（Double-Checked Locking）机制
 * 另外，可以使用静态内部类的方式实现懒汉式单例，该方式既具有延迟初始化的特性，又提供了较好的线程安全性和性能
 * */
public class LazySingleton {
    private static LazySingleton instance;

    // 将构造函数声明为私有，以防止外部直接实例化对象
    private LazySingleton() {}

    // 通过一个静态方法getInstance()来获取单例实例
    // 在该方法中，首先检查instance是否为null，如果是，则创建一个新的实例
    // 为了确保线程安全性，我们使用synchronized关键字对getInstance()方法进行同步，以保证在多线程环境下只有一个线程可以创建实例
    public static LazySingleton getInstance() {
        if (instance == null)
            instance = new LazySingleton();
        return instance;
    }
}
