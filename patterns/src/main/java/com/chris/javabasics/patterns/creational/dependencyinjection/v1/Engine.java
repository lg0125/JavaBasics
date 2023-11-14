package com.chris.javabasics.patterns.creational.dependencyinjection.v1;

// Engine interfaces implemented by the FastEngine class
//      and provided by EngineServiceProvider
public interface Engine {
    void start();
    boolean isStarted();
    void run();
    String type();
}
