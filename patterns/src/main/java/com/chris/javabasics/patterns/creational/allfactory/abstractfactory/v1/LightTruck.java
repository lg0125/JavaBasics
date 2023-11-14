package com.chris.javabasics.patterns.creational.allfactory.abstractfactory.v1;

public class LightTruck implements Vehicle {
    @Override
    public void move() {
        System.out.println("light truck, move");
    }
}
