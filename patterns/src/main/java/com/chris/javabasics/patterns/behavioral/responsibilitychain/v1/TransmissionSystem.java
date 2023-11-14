package com.chris.javabasics.patterns.behavioral.responsibilitychain.v1;

public final class TransmissionSystem extends VehicleSystem {
    public TransmissionSystem() {
        super(SystemType.TRANSMISSION);
    }

    @Override
    public void activate() {
        System.out.println("TransmissionSystem: activated");
    }
}
