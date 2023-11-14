package com.chris.javabasics.patterns.structral.decorator.v2;

import java.util.List;

public class BlackCoffeeMaker implements CoffeeMaker {
    @Override
    public List<String> getIngredients() {
        return List.of("Robusta Beans", "Water");
    }

    @Override
    public Coffee prepare() {
        return new BlackCoffee();
    }
}
