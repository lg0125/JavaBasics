package com.chris.javabasics.jucpatterns.singlethreadedexecution.deadlock.sample;

/**
 * 程序结果——Alice拿起勺子，Bobby拿起叉子，程序停止不动——deadlock发生
 * */
public class Main {
    public static void main(String[] args) {
        System.out.println("Testing EaterThread, hit CTRL+C to exit.");
        Tool spoon = new Tool("Spoon");
        Tool fork = new Tool("Fork");
        new EaterThread("Alice", spoon, fork).start();
        new EaterThread("Bobby", fork, spoon).start();
    }
}
