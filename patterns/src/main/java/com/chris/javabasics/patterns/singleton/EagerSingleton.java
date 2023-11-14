package com.chris.javabasics.patterns.singleton;

// 一种在类加载时就创建并初始化单例对象的实现方式
// 在该模式下，单例对象在程序运行期间一直存在，无论是否被使用

public class EagerSingleton {
    // 通过一个静态变量instance来持有单例对象，并在类加载时进行初始化
    // 饿汉式单例模式在类加载时就创建了单例对象，所以可以保证在任何使用该单例的地方都能获取到同一个实例
    private static final EagerSingleton instance = new EagerSingleton();

    // 将构造函数声明为私有，以防止外部直接实例化对象
    private EagerSingleton() {}

    public static EagerSingleton getInstance() {
        return instance;
    }
}
