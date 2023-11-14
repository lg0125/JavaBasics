package com.chris.javabasics.patterns.creational.lazyinitialization.v1;

public record LazyVehicle(String type) implements Vehicle {
    @Override
    public void move() {
        System.out.println("LazyVehicle, move, type:" + type);
    }
}
