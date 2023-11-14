package com.chris.javabasics.patterns.structral.adapter.v1;

// The ElectricEngine implementation provides an additional checkPlug method
public final class ElectricEngine implements Engine {
    @Override
    public void run() {
        System.out.println("ElectricEngine, run");
    }

    @Override
    public void tank() {
        System.out.println("ElectricEngine, recharging");
    }

    // Key Point
    public void checkPlug(){
        System.out.println("ElectricEngine, check plug");
    }
}
