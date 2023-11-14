package com.chris.javabasics.patterns.creational.allfactory.abstractfactory.v1;

/**
 * A key element of the game is the factory provider; this distinguishes which factory is created based on incoming arguments.
 * The provider is implemented as a utility, so its class is final, and the constructor is private because instances are not required.
 * */
public final class FactoryProvider {
    private FactoryProvider(){}

    public static AbstractFactory getFactory(String type){
        return switch (type) {
            case "car" -> new CarFactory();

            case "truck" -> new TruckFactory();

            default -> throw new IllegalArgumentException("""
                this is %s""".formatted(type)
            );
        };
    }
}
