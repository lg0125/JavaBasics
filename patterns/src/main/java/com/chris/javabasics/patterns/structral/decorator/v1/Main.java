package com.chris.javabasics.patterns.structral.decorator.v1;

public class Main {
    public static void main(String[] args) {
        CoffeeMaker coffeeMaker = new BlackCoffeeMaker();

        CoffeeMaker decoratedCoffeeMaker = new AddMilkDecorator(
                coffeeMaker,
                new MilkCarton()
        );

        Coffee cafeConLeche = decoratedCoffeeMaker.prepare();

        CoffeeMaker lastDecorated = new AddSugarDecorator(decoratedCoffeeMaker);

        Coffee sweetCafeConLeche = lastDecorated.prepare();

    }
}
