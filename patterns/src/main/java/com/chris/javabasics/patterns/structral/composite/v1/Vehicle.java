package com.chris.javabasics.patterns.structral.composite.v1;

public interface Vehicle<T extends VehicleElement<T>>
        extends VehicleElement<T> {
    void printParts();
}
