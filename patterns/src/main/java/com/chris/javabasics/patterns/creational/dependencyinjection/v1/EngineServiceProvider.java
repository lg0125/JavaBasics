package com.chris.javabasics.patterns.creational.dependencyinjection.v1;

import java.util.HashMap;
import java.util.Map;

// EngineServiceProvider registers instantiated reusable services
// The key player object is EngineServiceProvider.
// It provides a reference to already created desired Engine instances and distributes them across the business code.
// This means that any client that needs to work on Engine, similar to the SportVehicle instance,
//      will get access to the correct instance through the link exposed by EngineServiceProvider.
public final class EngineServiceProvider {
    private static final Map<String, Engine> ENGINES = new HashMap<>();

    private EngineServiceProvider(){}

    static void addEngine(Engine e){
        ENGINES.put(e.type(), e);
    }

    static Engine getEngineByType(String t){
        return ENGINES.values().stream()
                    .filter(e -> e.type().equals(t))
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
    }
}
