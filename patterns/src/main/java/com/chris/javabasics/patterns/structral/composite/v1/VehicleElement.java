package com.chris.javabasics.patterns.structral.composite.v1;

public interface VehicleElement<T extends VehicleElement<T>> {
    void addPart(T e);
}
