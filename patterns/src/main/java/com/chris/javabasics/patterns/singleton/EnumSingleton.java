package com.chris.javabasics.patterns.singleton;

// 使用枚举实现延迟初始化的单例
// 在Java中，枚举类型的实例是线程安全的，并且只会在首次访问时进行初始化
// 枚举单例的优点包括：
//      线程安全：枚举实例在多线程环境中是安全的，无需担心线程安全问题
//      延迟初始化：枚举实例在首次访问时进行初始化，实现了延迟初始化的效果
//      防止反射攻击：由于枚举类的实例是有限的且受控制的，不会受到反射攻击的影响
public enum EnumSingleton {
    // 定义了一个名为Singleton的枚举类型，其中包含一个名为INSTANCE的枚举实例
    // 这个实例在首次访问时被创建，并且可以通过Singleton.INSTANCE进行访问
    INSTANCE;

    public void doSomething() {
        // 单例实例的操作
    }
}
