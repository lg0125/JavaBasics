package com.chris.javabasics.patterns.structral.decorator.v3;

public class StandardVehicle implements Vehicle {
    @Override
    public void move() {
        System.out.println("StandardVehicle, move");
    }
}
