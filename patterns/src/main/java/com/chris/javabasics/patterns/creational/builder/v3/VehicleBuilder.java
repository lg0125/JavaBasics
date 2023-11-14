package com.chris.javabasics.patterns.creational.builder.v3;

public final class VehicleBuilder {
    // builder pattern I
    // One approach is to encapsulate and hide all builder logic and provide a product directly without exposing implementation details
    public static  Vehicle buildSlowVehicle(){
        var engine = new RecordPart("engine");
        var cabin = new StandardPart("cabin");
        return new SlowVehicle(engine, cabin);
    }
}
