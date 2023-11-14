package com.chris.javabasics.patterns.creational.allfactory.factory.v2;

import java.util.Objects;
import java.util.function.Function;

public enum ShapeType {
    CIRCLE(Circle::new),
    TRIANGLE(Triangle::new),
    SQUARE(Square::new),
    PENTAGON(Pentagon::new);

    /**
     * By fusing the factory with the enum,
     * the decision-making process(what factory method to call)
     *          gets replaced by binding the factory methods directly with ShapeType counterparts
     * */
    public final Function<Color, Shape> factory;
    ShapeType(Function<Color, Shape> factory) {
        this.factory = factory;
    }

    public Shape newInstance(Color color) {
        Objects.requireNonNull(color);
        return this.factory.apply(color);
    }
}
