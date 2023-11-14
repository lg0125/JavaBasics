package com.chris.javabasics.patterns.behavioral.template.v1;

public final class EngineSensor extends VehicleSensor {
    @Override
    protected void init() {
        System.out.println("EngineSensor, initiated");
    }

    @Override
    protected void startMeasure() {
        System.out.println("EngineSensor, measurement started");
    }

    @Override
    protected void storeData() {
        System.out.println("EngineSensor, data stored");
    }

    @Override
    protected void stopMeasure() {
        System.out.println("EngineSensor, measurement stopped");
    }
}
