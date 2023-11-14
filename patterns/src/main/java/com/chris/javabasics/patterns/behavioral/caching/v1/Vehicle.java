package com.chris.javabasics.patterns.behavioral.caching.v1;

public class Vehicle {
    private final SystemCache cache = new SystemCache(3);

    public void init(){
        cache.addSystem(new BreakSystem("break"));
        cache.addSystem(new EngineSystem("engine"));
        System.out.println("Vehicle, init cache:" + systemTypes());
    }

    public void addSystem(VehicleSystem s){
        if(!cache.addSystem(s))
            System.err.println("SystemCache, not stored:" + s);
    }

    public String systemTypes(){
        return cache.getSystemTypes();
    }

    public VehicleSystem getSystemByType(String type){
        return  cache.getSystem(type);
    }
}
