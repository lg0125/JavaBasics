package com.chris.javabasics.patterns.behavioral.responsibilitychain.v1;

public class Main {
    public static void main(String[] args) {
        System.out.println("Pattern Chain of Responsibility, vehicle system initialisation");

        var engineSystem        = new EngineSystem();
        var driverSystem        = new DriverSystem();
        var transmissionSystem  = new TransmissionSystem();

        driverSystem.setNext(transmissionSystem);
        transmissionSystem.setNext(engineSystem);

        driverSystem.powerOn();
    }
}
