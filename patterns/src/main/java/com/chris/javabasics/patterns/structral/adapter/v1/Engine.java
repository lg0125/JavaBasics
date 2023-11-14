package com.chris.javabasics.patterns.structral.adapter.v1;

// The sealed classes enforce the desired purpose and increase maintainability by protecting their intent,
// such as by avoiding unwanted extensions.
public  sealed interface Engine
        permits ElectricEngine, PetrolEngine {
    void run();
    void tank();
}
