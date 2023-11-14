package com.chris.javabasics.patterns.structral.decorator.v1;

import java.util.ArrayList;
import java.util.List;

public class AddMilkDecorator extends Decorator {
    private final MilkCarton milkCarton;

    // The constructor needs to accept all the requirements,
    //      so a MilkCarton is needed in addition to the CoffeeMaker.
    public AddMilkDecorator(CoffeeMaker target, MilkCarton milkCarton) {
        super(target);
        this.milkCarton = milkCarton;
    }

    // The decorator hooks into the getIngredients call
    //      by first calling super, making the result mutable, and
    //          adding the milk to the list of previously used ingredients.
    @Override
    public List<String> getIngredients() {
        var newIngredients = new ArrayList<>(super.getIngredients());
        newIngredients.add("Milk");
        return newIngredients;
    }

    // The prepare call also tasks super to do its intended purpose
    //      and “decorates” the resulting coffee with milk.
    @Override
    public Coffee prepare() {
        var coffee = super.prepare();
        coffee = this.milkCarton.pourInto(coffee);
        return coffee;
    }
}
