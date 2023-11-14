package com.chris.javabasics.patterns.singleton;

import java.util.HashMap;
import java.util.Map;

public class ContainerSingleton {
    private static Map<String, Object> instanceMap = new HashMap<>();

    private ContainerSingleton() {}

    public static void registerInstance(String key, Object instance) {
        if (!instanceMap.containsKey(key))
            instanceMap.put(key, instance);
    }

    public static Object getInstance(String key) {
        return instanceMap.get(key);
    }
}
