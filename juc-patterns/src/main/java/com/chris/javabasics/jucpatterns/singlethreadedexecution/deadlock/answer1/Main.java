package com.chris.javabasics.jucpatterns.singlethreadedexecution.deadlock.answer1;



/**
 * deadlock的解决方案I——Alice和Bobby以相同顺序拿取餐具
 * ShareResource角色是对称的 这一条件不成立
 * */
public class Main {
    public static void main(String[] args) {
        System.out.println("Testing EaterThread, hit CTRL+C to exit.");
        Tool spoon = new Tool("Spoon");
        Tool fork = new Tool("Fork");
        // Alice和Bobby以相同顺序拿取餐具 (勺子->叉子)
        new EaterThread("Alice", spoon, fork).start();
        new EaterThread("Bobby", spoon, fork).start();
    }
}
