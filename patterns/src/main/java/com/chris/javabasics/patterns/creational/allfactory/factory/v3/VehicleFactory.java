package com.chris.javabasics.patterns.creational.allfactory.factory.v3;

// The factory abstraction concentrates the whole vehicle composition process
//      and exposes only one entry point that allows the client to create the desired vehicle type
public final class VehicleFactory {
    // it makes sense to keep its constructor private because factory instances are undesirable:
    private VehicleFactory(){}

    // A factory only implements one static method
    public static Vehicle produce(String type){
        return switch (type) {
            case "sport" -> new SportCar("porsche 911");

            case "suv" -> new SuvCar("skoda kodiaq");

            default -> throw new IllegalArgumentException("""
                    not implemented type:'%s'
                    """.formatted(type)
            );
        };
    }
}
