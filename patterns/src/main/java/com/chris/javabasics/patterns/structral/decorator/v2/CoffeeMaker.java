package com.chris.javabasics.patterns.structral.decorator.v2;

import java.util.List;

public interface CoffeeMaker {
    List<String> getIngredients();

    Coffee prepare();
}
