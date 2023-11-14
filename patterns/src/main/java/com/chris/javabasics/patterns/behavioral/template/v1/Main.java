package com.chris.javabasics.patterns.behavioral.template.v1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Template method Pattern, changing transport options");

        Arrays.asList(new BreaksSensor(), new EngineSensor())
                .forEach(VehicleSensor::activate);
    }
}
