package com.chris.javabasics.patterns.behavioral.observer;

import java.util.Random;

public final class CockpitObserver extends SystemObserver {
    private static final Random RANDOM = new Random();

    public CockpitObserver(VehicleSystem system) {
        super(system);
        this.system.attach(this);
    }

    @Override
    public void update() {
        System.out.printf("""
                CockpitObserver, temperature:'%d'%n""", getTemperature());
    }

    private int getTemperature(){
        return RANDOM.nextInt(0, 30);
    }
}
