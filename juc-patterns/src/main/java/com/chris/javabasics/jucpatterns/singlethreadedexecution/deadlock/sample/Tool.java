package com.chris.javabasics.jucpatterns.singlethreadedexecution.deadlock.sample;

public class Tool {
    private final String name;
    public Tool(String name) {
        this.name = name;
    }
    public String toString() {
        return "[ " + name + " ]";
    }
}
