package com.chris.javabasics.patterns.creational.objectpool.v1;

import java.util.concurrent.atomic.AtomicInteger;

public class PooledVehicle implements Vehicle {
    // A counter belongs to a class, so it is marked as static and final.
    // The counter counts the number of instances purchased by the garage pool
    private static final AtomicInteger COUNTER = new AtomicInteger();

    private final int vin;

    public PooledVehicle() {
        this.vin = COUNTER.incrementAndGet();
    }

    @Override
    public int getVin(){
        return vin;
    }

    @Override
    public void move(){
        System.out.println("PooledVehicle, move, vin=" + vin);
    }
}
