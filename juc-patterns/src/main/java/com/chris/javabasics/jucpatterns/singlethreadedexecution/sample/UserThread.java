package com.chris.javabasics.jucpatterns.singlethreadedexecution.sample;

public class UserThread implements Runnable{
    private final Gate gate;
    private final String myname;
    private final String myaddress;

    // Blank Final——不在Final字段声明时赋初始值，而是在构造函数中将字段初始化
    public UserThread(Gate gate, String myname, String myaddress) {
        this.gate = gate;
        this.myname = myname;
        this.myaddress = myaddress;
    }

    @Override
    public void run() {
        System.out.println(myname + " BEGIN");

        while (true)
            gate.pass(myname, myaddress);
    }
}
