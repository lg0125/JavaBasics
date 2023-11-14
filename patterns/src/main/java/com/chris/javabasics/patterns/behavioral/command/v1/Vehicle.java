package com.chris.javabasics.patterns.behavioral.command.v1;

public final class Vehicle {
    private final String type;
    private boolean running;

    public Vehicle(String type) {
        this.type = type;
    }

    public void start() {
        this.running = true;
    }

    public void stop() {
        this.running = false;
    }

    public boolean isRunning() {
        return running;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "type='" + type + '\'' +
                ", running=" + running +
                '}';
    }
}
