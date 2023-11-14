package com.chris.javabasics.patterns.creational.allfactory.abstractfactory.v1;

// Each factory from the group shares common logic or features to maintain the DRY approach in the code base
public abstract class AbstractFactory {
    public abstract Vehicle createVehicle(String type);
}
