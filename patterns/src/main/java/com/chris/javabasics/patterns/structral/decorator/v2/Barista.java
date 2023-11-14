package com.chris.javabasics.patterns.structral.decorator.v2;

import java.util.Arrays;
import java.util.function.Function;

public final class Barista {
    // a parameterized decorate method that
    //   inverts the flow by accepting a Function<CoffeeMaker, CoffeeMaker> to actually do the process of decoration.
    public static CoffeeMaker decorate(CoffeeMaker coffeeMaker,
                                       Function<CoffeeMaker, CoffeeMaker> decorator) {
        return decorator.apply(coffeeMaker);
    }

    /**
     * The decoration process is effectively a reduction,
     *      with the original CoffeeMaker as its initial value, and
     *      the Function<CoffeeMaker, CoffeeMaker> accepting the previous value to create the new CoffeeMaker
     * */
    @SafeVarargs
    public static CoffeeMaker decorate(CoffeeMaker coffeeMaker /* The decorate method still accepts the original CoffeeMaker to decorate */,
                                       Function<CoffeeMaker, CoffeeMaker>... decorators) {
        // The decorations are composed with a Stream<Function<CoffeeMaker, Coffee Maker>
        //      by creating a Stream from the array and
        //      reducing all the elements to a single Function<CoffeeMaker, CoffeeMaker> by composing each of them.
        Function<CoffeeMaker, CoffeeMaker> reducedDecorations =
                Arrays.stream(decorators).reduce(
                        Function.identity(),
                        Function::andThen
                );

        // Finally, the singular reduced decoration is composed with CoffeeMaker.
        return reducedDecorations.apply(coffeeMaker);
    }

    private Barista() {
        // Suppress default constructor.
        // Ensures non-instantiability and non-extendability.
    }
}
