package com.chris.javabasics.patterns.structral.adapter;

public class Note {
    /*
    * Incompatible object collaboration with the adapter pattern
    *
    * The main goal of the adapter pattern is to connect the source class interface to another interface that clients will expect.
    *   The adapter pattern allows classes to work together that otherwise could not due to an incompatible abstraction or implementation.
    *   It is considered one of the most common patterns and is one of the Gang of Four (GoF) design patterns.
    *
    * Motivation
    *   The adapter pattern is also known as wrapper.
    *   An adapter wraps the behavior of the adaptee (connected class) and allows access to the adaptee without modification using an already existing interface.
    *   Commonly, an adaptee uses an incompatible interface, and an adapter consolidates such behavior and transparently provides access to the required functionality.
    *
    * JDK
    *   The Collections utility class from the java.util package provides a list method,
    *       which accepts an Enumeration interface and adapts the result into an ArrayList instance.
    *
    * The adapter structural design pattern has a valid place in development
    *   as it represents a maintainable way to connect different functionalities and control them through a similar interface.
    *
    * The adapter is properly encapsulated and can be even more abstract.
    *
    * The new sealed classes support the pattern concept of maintainability and clarity.
    *
    * The consequence of using the adapter pattern may be that the adapter needs to commit to a specific adaptee or interface.
    *
    * The adapter may extend some of the adaptee functionalities as a subclass.
    *
    * The adapter pattern is worth considering when additional third-party libraries or APIs are to be implemented.
    *   It provides a transparent and decoupled way to interact with libraries, following the SOLID concept.
    *
    * This look at the adapter pattern has shown the approach of using incompatible APIs.
    * */
}
