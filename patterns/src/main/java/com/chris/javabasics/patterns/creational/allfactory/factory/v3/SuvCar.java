package com.chris.javabasics.patterns.creational.allfactory.factory.v3;

public record SuvCar(String type) implements Vehicle {
    @Override
    public void move() {
        System.out.printf("""
                SuvCar, type:'%s', move%n""",
                type
        );
    }
}
