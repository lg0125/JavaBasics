package com.chris.javabasics.jucpatterns.singlethreadedexecution.sample;

/**
 * 线程安全的Gate类
 *      分别在pass方法和toString方法前面加上synchronized关键字，即声明为synchronized方法
 *      synchronized关键字保护counter name address这三个字段，确保这些字段不可被多个线程同时访问
 * <p>
 * synchronized方法能够确保该方法在同一时刻下只能由一个线程执行
 *      也就是说，线程Alice执行完pass方法之前，线程Bobby就阻塞在pass方法的入口处
 *      线程Alice执行完pass方法，释放锁之后，线程Bobby才能够开始执行pass方法
 * */
public class Gate {
    /**
     * 之所以将字段声明为private，是为了便于开发者确认类的安全
     * <p>
     * private字段——只有在该类内部才可以访问
     *      因此，只要确认该类中声明的方法是否在安全地访问字段，便可以确认字段的安全性
     * protected字段——可以被该类的子类和同一个包内的类访问
     *      确认安全性时，必须对子类和同一个包内的类进行query
     * public字段——可以被任何类访问
     *      确认安全性时，必须对访问该字段的类都进行确认
     * <p>
     * 多个线程共享的字段必须使用synchronized或volatile关键字加以保护
     * */
    private int counter = 0;
    private String name = "Nobody";
    private String address = "Nowhere";

    public synchronized void pass(String name, String address) {
        this.counter++;
        this.name = name;
        this.address = address;
        check();
    }

    public synchronized String toString() {
        return "No." + counter + ": " + name + ", " + address;
    }

    /**
     * 为何check方法不声明为synchronized方法？
     *      只有pass方法调用了check方法，而pass方法已经声明为synchronized方法
     *      由于check方法声明为private，故从该类外部并不可以调用该方法
     *      因此，check方法无需声明为synchronized方法
     * */
    private void check() {
        if (name.charAt(0) != address.charAt(0)) {
            System.out.println("***** BROKEN ***** " + this);
        }
    }
}
