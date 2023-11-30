package com.chris.javabasics.patterns.structral.decorator.v2;

import java.util.function.Function;

// only the CoffeeMaker type and additional ingredients like MilkCarton are involved.
public final class Decorations {
    public static Function<CoffeeMaker, CoffeeMaker> addMilk(MilkCarton milkCarton) {
        return
                coffeeMaker -> new AddMilkDecorator(
                        coffeeMaker,
                        milkCarton
                );
    }

    public static Function<CoffeeMaker, CoffeeMaker> addSugar() {
        return AddSugarDecorator::new;
    }

    // ...
}
