package com.chris.javabasics.jucpatterns.singlethreadedexecution.deadlock.answer2;

/**
 * deadlock解决方案II——勺子、叉子成对拿取
 * 存在多个SharedResource角色 这一条件不成立
 * */
public class Pair {
    private final Tool lefthand;
    private final Tool righthand;

    public Pair(Tool lefthand, Tool righthand) {
        this.lefthand = lefthand;
        this.righthand = righthand;
    }

    public String toString() {
        return "[ " + lefthand + " and " + righthand + " ]";
    }
}
