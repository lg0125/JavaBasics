package com.chris.javabasics.patterns.structral.adapter.v1;

public class Main {
    public static void main(String[] args) {
        System.out.println("Adapter Pattern: engines");
        var electricEngine      = new ElectricEngine();
        var enginePetrol        = new PetrolEngine();
        var vehicleElectric     = new Vehicle(electricEngine);
        var vehiclePetrol       = new Vehicle(enginePetrol);

        vehicleElectric.drive();
        vehicleElectric.refuel();
        vehiclePetrol.drive();
        vehiclePetrol.refuel();
    }
}
