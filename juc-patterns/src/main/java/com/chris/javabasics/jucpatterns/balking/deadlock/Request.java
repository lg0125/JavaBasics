package com.chris.javabasics.jucpatterns.balking.deadlock;

public record Request(String name) {

    public String toString() {
        return "[ Request " + name + " ]";
    }
}
