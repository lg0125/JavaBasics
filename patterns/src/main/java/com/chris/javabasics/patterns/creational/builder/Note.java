package com.chris.javabasics.patterns.creational.builder;

public class Note {
    /*
    * The builder pattern is another creational pattern for creating more complex data structures
    *       by separating the construction from the representation itself.
    * It solves various object creation problems, like multistep creation and validation, and improves non-mandatory argument handling.
    *
    * Instantiating complex objects with the builder pattern
    *       The builder pattern helps separate the construction of a complex object from its code representation
    *           so that the same composition process can be reused to create different configurations of an object type.
    *
    * Motivation
    *   The main motivation behind the builder pattern is to construct complex instances without polluting the constructor.
    *   It helps to separate or even break down the creation process into specific steps.
    *   The composition of objects is transparent to the client and allows the creation of different configurations of the same type.
    *   The builder is represented by a separate class. It can help to transparently extend the constructor on demand.
    *   The pattern helps to encapsulate and enforce the clarity of the instantiation process with respect to the previously discussed SOLID design principles.
    *
    * JDK
    *   StringBuilder and StringBuffer are located  in the java.lang package of the java.base module
    *       The string builder provides multiple overloaded connection methods that accept different types of input.
    *       Such input is concatenated with an already-created byte array
    *
    *   Stream.Builder interface found in the java.util.stream package.
    *
    *   in the java.net.http package represented by the HttpRequest.Builder interface  and its implementation
    *
    *   Worth noting are Locale.Builder and Calendar.Builder,
    *       which use the setter methods to store values of the final product.
    *       Both can be found in the java.util package of the java.based module.
    *
    * The builder, which is the key element of the pattern, holds references to the objects during a Vehicle instance creation
    *
    * The builder pattern helps enforce the single responsibility principle by separating complex creation  from business logic.
    * It also improves code readability and the DRY principle, as the instantiation is extensible and user-understandable.
    *
    * while implementing a pattern is to use the JVM’s heap or stack – more specifically,
    *   to create a statically or dynamically allocated representation of the pattern.
    *
    *
    * */
}
