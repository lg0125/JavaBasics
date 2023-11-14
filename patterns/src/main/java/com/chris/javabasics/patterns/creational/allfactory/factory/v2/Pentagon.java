package com.chris.javabasics.patterns.creational.allfactory.factory.v2;

public record Pentagon(Color color) implements Shape {
    @Override
    public int corners() {
        return 0;
    }

    @Override
    public ShapeType type() {
        return ShapeType.PENTAGON;
    }
}
