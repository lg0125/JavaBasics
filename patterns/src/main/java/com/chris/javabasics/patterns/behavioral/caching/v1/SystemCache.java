package com.chris.javabasics.patterns.behavioral.caching.v1;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// The vehicle’s SystemCache only considers specific types of instances and is also limited by size
// The SystemCache instance provides features to ensure program stability and may give additional guarantees
public class SystemCache {
    private final VehicleSystem[] systems;
    private int end;

    public SystemCache(int capacity) {
        this.systems = new VehicleSystem[capacity];
    }

    public boolean addSystem(VehicleSystem system) {
        var availableSystem = getSystem(system.type());

        if (availableSystem == null && end < systems.length) {
            systems[end++] = system;
            return true;
        }

        return false;
    }

    public VehicleSystem getSystem(String type) {
        for (var s : systems)
            if (s != null && s.type().equals(type)) return s;
        return null;
    }

    public int currentSize(){
        return end;
    }

    public String getSystemTypes() {
        return Stream.of(systems)
                .filter(Objects::nonNull)
                .map(s -> """
                        '%s':'%s'""".formatted(s.type(), s))
                .collect(Collectors.joining(","));
    }
}
