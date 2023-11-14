package com.chris.javabasics.patterns.behavioral.caching.v1;

public class Main {
    public static void main(String[] args) {
        System.out.println("Caching Pattern, initiated vehicle system");

        var vehicle = new Vehicle();
        vehicle.init();

        var suspension = new SuspensionSystem("suspension");
        vehicle.addSystem(suspension);

        System.out.printf("Systems types:'%s%n\n", vehicle.systemTypes());

        var suspensionCache = vehicle.getSystemByType("suspension");

        System.out.printf("Is suspension equal? '%s:%s'%n\n", suspension.equals(suspensionCache), suspensionCache);

        vehicle.addSystem(new EngineSystem("engine2"));
    }
}
