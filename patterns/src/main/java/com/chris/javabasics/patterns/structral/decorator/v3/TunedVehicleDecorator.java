package com.chris.javabasics.patterns.structral.decorator.v3;

public sealed abstract class TunedVehicleDecorator
        implements Vehicle
        permits SportVehicle {
    private final Vehicle vehicle;

    public TunedVehicleDecorator(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void move() {
        System.out.println("TunedVehicleDecorator, turbo on");
        vehicle.move();
    }
}
