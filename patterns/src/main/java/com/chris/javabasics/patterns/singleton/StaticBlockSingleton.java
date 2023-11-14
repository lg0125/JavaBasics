package com.chris.javabasics.patterns.singleton;

/**
 * 由于静态块在类加载时执行，因此保证了在任何使用该单例的地方都能获取到同一个实例
 * 并且，静态块也可以处理可能出现的异常，如在初始化过程中抛出异常时，可以在静态块中捕获并进行相应的处理
 * <p>
 * 需要注意的是，静态块中创建的对象是在类加载时创建的，因此无法实现延迟加载
 * 无论是否使用该单例对象，它都会在类加载时被创建和初始化
 * 这可能会导致资源浪费，特别是在单例对象较为复杂且初始化耗时较长的情况下
 * */
public class StaticBlockSingleton {
    // 定义了一个私有的静态变量instance
    private static final StaticBlockSingleton instance;

    private StaticBlockSingleton() {}

    // 在静态块中进行对象的创建和初始化
    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create singleton instance");
        }
    }

    public static StaticBlockSingleton getInstance() {
        return instance;
    }
}
