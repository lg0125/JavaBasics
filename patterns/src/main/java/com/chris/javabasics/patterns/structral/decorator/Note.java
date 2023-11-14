package com.chris.javabasics.patterns.structral.decorator;

public class Note {
    /*
          The decorator pattern is a structural pattern that allows for modifying object behavior at runtime.

          Instead of subclassing,
               an object is wrapped inside a “decorator” that contains the desired behavior

          v1
          The object-oriented implementation of this pattern requires that
               the decorators share an interface with the type they’re supposed to decorate.
          To simplify writing a new decorator,
               an abstract class implementing the shared interface is used as a starting point for any decorator

          v2
          The decorator pattern consists of two parts that are suitable for improvement:
            • Decorating a CoffeeMaker with one or more decorators
                The first part of “how to decorate” boils down to taking an existing CoffeeMaker
                and “somehow” adding the new behavior and returning a new CoffeeMaker to be used instead.

                In essence, the process looks like a Function<CoffeeMaker, CoffeeMaker>.

                the logic is bundled as a static higher-order method in a convenience type.
                This method accepts a CoffeeMaker and a decorator and combines them with functional composition
            • Creating a Decorator itself
           The main advantage of a functional approach is
                the possible elimination of explicit nesting and exposing the concrete implementation types

           Extending object functionality by using the decorator pattern

           The decorator pattern provides the ability to add new functionality to objects by placing those objects in a decorator,
                so that a decorated instance provides extended functionality.

           Motivation
           With the decorator pattern, you can dynamically attach additional responsibilities to an object.

           A decorator provides a flexible alternative to subclasses to extend the functionality of a class.

           The decorator can be added statically or dynamically without altering the current behavior of an object.

           JDK
           Uses of the decorator pattern can be found in the Java collections framework(JCF), the java.base module, and the java.util package.

           The Collection class contains different ways to use the decorator pattern.
                For example, the unmodifiableCollection method wraps the requested collection into an unmodifiable collection
                    represented by an UnmodifiableCollection instance that acts as a decorator for the provided collection type,
                    similar to other methods starting with unmodifiable... words.

           Another example is methods starting with the word synchronized...of the Collections utility class

           Decoration helps not only to add new features but also to remove obsolete features.

           The decorator pattern is a transparent way to modify an object without disrupting the current interface.
      */
}
