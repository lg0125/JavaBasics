package com.chris.javabasics.patterns.singleton;

import java.util.concurrent.atomic.AtomicReference;

// 线程安全的懒汉式单例
// 使用CAS实现线程安全的懒汉式单例可以避免使用锁，提供更好的性能
public class CasSingleton {
    // 使用AtomicReference来存储单例实例
    // AtomicReference提供了compareAndSet方法，该方法比较当前值与期望值，如果相等则进行替换
    private static final AtomicReference<CasSingleton> INSTANCE = new AtomicReference<>();

    private CasSingleton() {
        // 私有构造函数
    }

    public static CasSingleton getInstance() {
        while (true) {
            CasSingleton currentInstance = INSTANCE.get();
            if (currentInstance != null)
                return currentInstance;

            CasSingleton newInstance = new CasSingleton();
            // 通过循环调用compareAndSet方法，尝试将新创建的实例设置为单例实例，确保只有一个实例被创建
            if (INSTANCE.compareAndSet(null, newInstance))
                return newInstance;
        }
    }
}
