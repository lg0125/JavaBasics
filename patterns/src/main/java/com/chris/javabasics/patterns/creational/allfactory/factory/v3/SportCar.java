package com.chris.javabasics.patterns.creational.allfactory.factory.v3;

public record SportCar(String type) implements Vehicle {
    @Override
    public void move() {
        System.out.printf("""
                SportCar, type:'%s', move%n""", type
        );
    }
}
