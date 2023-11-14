package com.chris.javabasics.patterns.creational.allfactory.factory.v1;

public record Square(Color color) implements Shape {
    @Override
    public int corners() {
        return 0;
    }

    @Override
    public ShapeType type() {
        return ShapeType.SQUARE;
    }
}
