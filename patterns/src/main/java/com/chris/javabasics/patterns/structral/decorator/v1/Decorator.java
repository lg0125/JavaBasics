package com.chris.javabasics.patterns.structral.decorator.v1;

import java.util.List;

/**
 * The goal is to decorate the coffee maker to add functionality like adding milk or sugar to your coffee.
 *      Therefore, a decorator has to accept the coffee maker and decorate the prepare method
 * <p>
 * The abstract Decorator type aggregates the minimal required functionality
 *      to decorate a CoffeeMaker in a singular type
 * <p>
 * The Decorator implements CoffeeMaker so that it’s usable as a drop-in replacement
 * */
public abstract class Decorator implements CoffeeMaker {
    private final CoffeeMaker target;

    // The constructor accepts the original CoffeeMaker instance that’s supposed to be decorated.
    public Decorator(CoffeeMaker target) {
        this.target = target;
    }

    /**
     * The getIngredients and prepare methods simply call the decorated CoffeeMaker,
     * so any actual decorator can use a super call to get the “original” result.
     * */
    @Override
    public List<String> getIngredients() {
        return this.target.getIngredients();
    }

    @Override
    public Coffee prepare() {
        return this.target.prepare();
    }
}
