package com.chris.javabasics.patterns.creational.allfactory.abstractfactory.v1;

public class CarFactory extends AbstractFactory {
    @Override

    public Vehicle createVehicle(String type) {
        return switch (type) {
            case "slow" -> new SlowCar();
            case "fast" -> new FastCar();
            default -> throw new IllegalArgumentException("not implemented");
        };
    }
}
