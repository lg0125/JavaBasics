package com.chris.javabasics.patterns.behavioral.responsibilitychain.v1;

public final class EngineSystem extends VehicleSystem {
    public EngineSystem() {
        super(SystemType.ENGINE);
    }

    @Override
    public void activate() {
        System.out.println("EngineSystem, activated");
    }
}
