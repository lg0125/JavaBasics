package com.chris.javabasics.patterns.creational.dependencyinjection.v1;

// The SportVehicle class implements the Vehicle interface
//      in order to reflect the open-close approach mentioned as part of the SOLID design principles:
// SportVehicle implements the Vehicle interface
//      together with additional internal logic for the provided Engine instance
public class SportVehicle implements Vehicle {
    private final Engine engine;

    SportVehicle(Engine e) {
        this.engine = e;
    }

    @Override
    public void move() {
        if(!engine.isStarted())
            engine.start();
        engine.run();
        System.out.println("SportCar, move");
    }
}
