package com.chris.javabasics.patterns.structral.decorator.v1;

import java.util.List;

// a coffee maker with a single method to prepare coffee
// The shared interface
public interface CoffeeMaker {
    List<String> getIngredients();

    Coffee prepare();
}
