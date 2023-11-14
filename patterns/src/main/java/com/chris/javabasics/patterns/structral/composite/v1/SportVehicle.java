package com.chris.javabasics.patterns.structral.composite.v1;

import java.util.ArrayList;
import java.util.List;

/**
 * To explore the power of the composition pattern, consider the SportVehicle class,
 *      which implements the Vehicle interface.
 * It is standard knowledge that
 *      every vehicle is a collection of parts and every part is a grouping of smaller parts
 * When the vehicle manufacturing process starts,
 *      the composition pattern provides a complete collection of every part that is present in the final results
 * */
public class SportVehicle
        implements Vehicle<VehiclePart> {
    private final String type;
    private final List<VehiclePart> parts;

    SportVehicle(String type) {
        this.type = type;
        this.parts = new ArrayList<>();
    }

    @Override
    public void addPart(VehiclePart p) {
        this.parts.add(p);
    }

    @Override
    public void printParts() {
        System.out.printf("""
                SportCar, type'%s', parts:'%s'%n""", type, parts);
    }
}
