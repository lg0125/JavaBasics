package com.chris.javabasics.jucpatterns.immutable.sample;

/**
 * Person类的实例一旦创建，其字段的值就不会发生改变
 * 即便多个线程同时访问同一个实例，Person类也是安全的
 * Person类的所有方法允许多个线程同时执行
 * <p>
 * Person类声明为final类型，这就表示无法创建Person类的子类
 *      这是为了防止子类修改其字段值
 * */
public final class Person {
    /**
     * 字段的可见性声明为private
     *      表明字段只有从该类的内部才可以访问
     *      这是为了防止子类修改器字段值
     * 字段声明为final
     *      一旦字段被赋值一次，就不会再被赋值
     * */
    private final String name;

    private final String address;

    /**
     * Person类的字段值仅可以通过构造函数来设置
     * 有getter、无setter
     * */
    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String toString() {
        return "[ Person: name = " + name + ", address = " + address + " ]";
    }
}

