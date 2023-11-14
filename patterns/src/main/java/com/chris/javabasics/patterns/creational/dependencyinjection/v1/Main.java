package com.chris.javabasics.patterns.creational.dependencyinjection.v1;

// Creating an instance of FastEngine separately from the vehicle
//  `and then adding the engine to the constructed SportVehicle
public class Main {
    // The FastEngine instance is used when it is fully ready (initiated, verified, and so on)
    // The desired type of vehicle can be constructed independently without any dependence on engine logic
    // An engine instance is provided to SportVehicle using EngineServiceProvider
    public static void main(String[] args) {
        System.out.println("Pattern Dependency Injection: vehicle and engine");

        EngineServiceProvider.addEngine(new FastEngine("sport"));

        Engine engine = EngineServiceProvider.getEngineByType("sport");

        Vehicle vehicle = new SportVehicle(engine);
        vehicle.move();
    }
}
