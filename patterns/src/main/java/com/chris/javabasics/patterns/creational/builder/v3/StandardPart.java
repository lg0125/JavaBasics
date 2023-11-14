package com.chris.javabasics.patterns.creational.builder.v3;

public class StandardPart implements Part {
    private final String name;

    StandardPart(String name){
        this.name = name;
    }

    @Override
    public String name() {
        return null;
    }
}
