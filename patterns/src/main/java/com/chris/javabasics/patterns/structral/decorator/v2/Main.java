package com.chris.javabasics.patterns.structral.decorator.v2;

public class Main {
    public static void main(String[] args) {
        CoffeeMaker decoratedCoffeeMaker = Barista.decorate(
                new BlackCoffeeMaker(),
                coffeeMaker -> new AddMilkDecorator(
                        coffeeMaker,
                        new MilkCarton()
                )
        );

        System.out.println(
                "[Parameterized] Ingredients for Café con Leche: " +
                        decoratedCoffeeMaker.getIngredients()
        );

        CoffeeMaker finalCoffeeMaker = Barista.decorate(
                decoratedCoffeeMaker,
                AddSugarDecorator::new
        );

        System.out.println(
                "[Parameterized] Ingredients after adding sugar: " +
                        finalCoffeeMaker.getIngredients()
        );

        CoffeeMaker multiDecoratedCoffeeMaker = Barista.decorate(
                new BlackCoffeeMaker(),
                coffeeMaker -> new AddMilkDecorator(
                        coffeeMaker,
                        new MilkCarton()
                ),
                AddSugarDecorator::new
        );

        System.out.println(
                "[Multi] Ingredients: " +
                        multiDecoratedCoffeeMaker.getIngredients()
        );

        CoffeeMaker maker = Barista.decorate(
                new BlackCoffeeMaker(),
                Decorations.addMilk(new MilkCarton()),
                Decorations.addSugar()
        );

        System.out.println("[Helper] Ingredients: " + maker.getIngredients());
    }
}
