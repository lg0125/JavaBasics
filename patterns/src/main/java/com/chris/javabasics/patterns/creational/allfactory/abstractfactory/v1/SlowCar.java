package com.chris.javabasics.patterns.creational.allfactory.abstractfactory.v1;

public class SlowCar implements Vehicle {
    @Override
    public void move() {
        System.out.println("slow car, move");
    }
}
