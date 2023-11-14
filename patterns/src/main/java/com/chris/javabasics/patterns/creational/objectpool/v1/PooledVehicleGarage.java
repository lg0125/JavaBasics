package com.chris.javabasics.patterns.creational.objectpool.v1;

public class PooledVehicleGarage extends AbstractGaragePool<PooledVehicle> {
    @Override
    protected PooledVehicle buyVehicle() {
        return new PooledVehicle();
    }
}
