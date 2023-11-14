package com.chris.javabasics.patterns.behavioral.responsibilitychain.v1;


public final class DriverSystem extends VehicleSystem {
    public DriverSystem() {
        super(SystemType.DRIVER);
    }

    @Override
    public void activate() {
        System.out.println("DriverSystem: activated");
    }
}
