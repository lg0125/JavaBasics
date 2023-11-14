package com.chris.javabasics.patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class VehicleSystem {
    // key point
    private final List<SystemObserver> observers = new ArrayList<>();

    private String state;

    String state() {
        return state;
    }

    void setState(String s) {
        this.state = s;
        observersNotifyAll();
    }

    void attach(SystemObserver systemObserver){
        observers.add(systemObserver);
    }

    private void observersNotifyAll(){
        observers.forEach(SystemObserver::update);
    }
}
