package com.chris.javabasics.patterns.creational.allfactory.abstractfactory.v1;

public class Main {
    public static void main(String[] args) {
        System.out.println("Pattern Abstract Factory: Vehicle Factory 1...");

        AbstractFactory carFactory = FactoryProvider.getFactory("car");
        Vehicle slowCar = carFactory.createVehicle("slow");
        slowCar.move();
    }
}
