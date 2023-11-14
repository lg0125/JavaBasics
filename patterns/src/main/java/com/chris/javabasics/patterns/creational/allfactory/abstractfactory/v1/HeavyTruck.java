package com.chris.javabasics.patterns.creational.allfactory.abstractfactory.v1;

public class HeavyTruck implements Vehicle {
    @Override
    public void move() {
        System.out.println("heavy truck, move");
    }
}
