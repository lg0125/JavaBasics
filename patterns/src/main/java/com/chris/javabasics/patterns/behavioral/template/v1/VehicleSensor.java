package com.chris.javabasics.patterns.behavioral.template.v1;

public sealed abstract class VehicleSensor
        permits BreaksSensor, EngineSensor {
    protected abstract void init();
    protected abstract void startMeasure();
    protected abstract void storeData();
    protected abstract void stopMeasure();

    public final void activate(){
        init();
        startMeasure();
        storeData();
        stopMeasure();
    }
}
