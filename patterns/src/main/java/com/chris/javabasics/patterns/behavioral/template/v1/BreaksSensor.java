package com.chris.javabasics.patterns.behavioral.template.v1;

public final class BreaksSensor extends VehicleSensor {
    @Override
    protected void init() {
        System.out.println("BreaksSensor, initiated");
    }

    @Override
    protected void startMeasure() {
        System.out.println("BreaksSensor, measurement started");
    }

    @Override
    protected void storeData() {
        System.out.println("BreaksSensor, data stored");
    }

    @Override
    protected void stopMeasure() {
        System.out.println("BreaksSensor, measurement stopped");
    }
}
