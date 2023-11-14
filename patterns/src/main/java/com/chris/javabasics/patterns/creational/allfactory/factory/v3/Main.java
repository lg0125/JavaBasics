package com.chris.javabasics.patterns.creational.allfactory.factory.v3;

public class Main {
    public static void main(String[] args) {
        System.out.println("Pattern Factory Method: Vehicle Factory 2");

        var sportCar = VehicleFactory.produce("suv");
        System.out.println("sport-car:" + sportCar);

        sportCar.move();
    }
}
