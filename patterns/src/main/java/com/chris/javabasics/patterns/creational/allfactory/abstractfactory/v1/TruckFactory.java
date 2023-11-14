package com.chris.javabasics.patterns.creational.allfactory.abstractfactory.v1;

public class TruckFactory extends AbstractFactory {
    @Override
    public Vehicle createVehicle(String type) {
        return switch(type) {
            case "heavy" -> new HeavyTruck();

            case "light" -> new LightTruck();

            default -> throw new IllegalArgumentException("not implemented");
        };
    }
}
