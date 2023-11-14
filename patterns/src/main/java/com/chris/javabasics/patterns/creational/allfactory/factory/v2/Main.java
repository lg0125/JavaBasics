package com.chris.javabasics.patterns.creational.allfactory.factory.v2;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        var circle = ShapeType.CIRCLE.newInstance(Color.RED);
        System.out.println(circle.type() + " " + circle.color());

        Function<Shape, Shape> cornerPrint =
                shape -> {
                    System.out.println("Shape created with " + shape.corners() + " corners.");
                    return shape;
                };

        circle = ShapeType.CIRCLE.factory.andThen(cornerPrint)
                    .apply(Color.RED);

    }
}
