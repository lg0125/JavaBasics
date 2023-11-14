package com.chris.javabasics.patterns.creational.allfactory.factory.v1;

public class Main {
    public static void main(String[] args) {
        var shape = ShapeFactory.newShape(ShapeType.CIRCLE, Color.RED);
        System.out.println(shape.type() + "," + shape.color());

        shape = ShapeFactory.newShape(ShapeType.PENTAGON, Color.YELLOW);
        System.out.println(shape.type() + "," + shape.color());
    }
}
