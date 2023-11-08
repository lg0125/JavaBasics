package com.chris.javabasics.jucpatterns.singlethreadedexecution.sample;

/**
 * 模拟三个人频繁地通过一个只允许一个人经过的门的情形
 * 当人们通过门的时候，统计人数便会递增
 * 门还会记录同行者的姓名和出生地
 * <p>
 * Main——创建一个门(Gate)，并让三个人(UserThread)不断地通过
 * 创建Gate类的实例，并将该实例作为参数传递给UserThread类的构造参数，告诉人们“请通过这个门”
 * */
public class Main {
    public static void main(String[] args) {
        System.out.println("Testing Gate, hit CTRL+C to exit.");
        Gate gate = new Gate();
        new Thread(new UserThread(gate, "Alice", "Alaska")).start();
        new Thread(new UserThread(gate, "Bobby", "Brazil")).start();
        new Thread(new UserThread(gate, "Chris", "Canada")).start();
    }
}
