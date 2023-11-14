package com.chris.javabasics.patterns.behavioral.responsibilitychain.v1;

public abstract class VehicleSystem {
    protected final SystemType type;
    protected VehicleSystem nextSystem;
    protected boolean active;

    public VehicleSystem(SystemType type) {
        this.type = type;
    }

    public void setNext(VehicleSystem system){
        this.nextSystem = system;
    }

    public void powerOn(){
        if(!this.active)
            activate();

        if(nextSystem != null)
            nextSystem.powerOn();
    }

    public abstract void activate();
}
