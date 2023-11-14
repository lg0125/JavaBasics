package com.chris.javabasics.patterns.creational.lazyinitialization.v1;

public class VehicleProvider {
    private Vehicle truck;
    private Vehicle car;

    public VehicleProvider() {}

    public Vehicle getVehicleByType(String type){
        return switch (type) {
            case "car" -> {
                if (car == null) {
                    System.out.println("lazy car created");
                    car = new LazyVehicle(type);
                }
                yield car;
            }
            case "truck" -> {
                if (truck == null) {
                    System.out.println("lazy truck created");
                    truck = new LazyVehicle(type);
                }
                yield truck;
            }
            default -> throw new IllegalArgumentException("not implemented");
        };

    }

    void printStatus(){
        System.out.println("status, truck:" + truck);
        System.out.println("status, car:" + car);
    }
}
