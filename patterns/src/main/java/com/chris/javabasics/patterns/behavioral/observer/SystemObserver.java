package com.chris.javabasics.patterns.behavioral.observer;

// The SystemObserver abstract class not only denotes the subsystem under consideration using the construction of sealed classes
//      but also provides a basic template for constructing the intended subsystem
public sealed abstract class SystemObserver
        permits CockpitObserver, EngineObserver {
    // key point
    protected final VehicleSystem system;

    public SystemObserver(VehicleSystem system) {
        this.system = system;
    }

    public abstract void update();
}
