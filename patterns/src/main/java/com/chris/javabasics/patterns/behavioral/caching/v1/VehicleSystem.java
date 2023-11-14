package com.chris.javabasics.patterns.behavioral.caching.v1;

public sealed interface VehicleSystem permits BreakSystem, EngineSystem, SuspensionSystem {
    String type();
    void init();
    boolean active();
}
