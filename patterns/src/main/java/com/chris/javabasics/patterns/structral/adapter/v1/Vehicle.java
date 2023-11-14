package com.chris.javabasics.patterns.structral.adapter.v1;

// the Vehicle class and its instance play the role of adapter
// The Vehicle adapter provides the required logic to handle the different engine implementations properly.
public class Vehicle {
    private final Engine engine;

    public Vehicle(Engine engine) {
        this.engine = engine;
    }

    public void drive(){
        System.out.println("Vehicle, drive");
        engine.run();
    }

    public void refuel(){
//        System.out.println("Vehicle, stop");
//        switch (engine){
//            case ElectricEngine de -> {
//                System.out.println("Vehicle needs recharge");
//
//                // adaptee
//                de.checkPlug();
//
//                de.tank();
//            }
//
//            case PetrolEngine pe -> {
//                System.out.println("Vehicle needs petrol");
//
//                pe.tank();
//            }
//
//            default -> throw new IllegalStateException("Vehicle has no engine");
//        }
    }
}
