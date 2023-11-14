package com.chris.javabasics.patterns.creational.allfactory.abstractfactory;

public class Note {
    /*
    * This pattern introduces a factory abstraction without the requirement to define specific classes (or classes that should be instantiated).
    *   The client requests a proper factory that instantiates the object instead of attempting to create it.
    *
    * The motivation is to separate the factory logic from the application code
    *       so that it can supply the appropriate factory to produce the required objects.
    *
    * An abstract factory provides  a standardized way to create an instance of the desired factory and deliver that instance to the client for use.
    *   The client uses the resulting factory to instantiate the object.
    *
    * Abstract factory provides an interface for creating both factories and objects without specifying their classes.
    *
    * The pattern implicitly supports SOLID principles and maintainability by isolating the logic of participants and insiders.
    *   The application is independent of how its products are created, composed, and represented.
    *
    * JDK
    * The abstract factory method pattern can be found in the JDK in the java.xml package of the java.xml module
    *
    * The abstract factory pattern can be found in the representation and implementation of the DocumentBuilderFactory abstract class and its static newInstance method.
    * The factory uses a lookup service to find the required builder implementation.
    *
    * An important feature is that each factory can implement its own initialization sequence while sharing generic logic.
    *
    * The abstract factory pattern provides consistency across products.
    *
    * An abstract factory is free to represent the many other interfaces that came with its implementation.
    * The pattern provides a common way to deal with products without depending on their implementation,
    *   which can improve the separation of concerns of application code.
    * It can use interfaces or abstract classes. The client becomes independent of how objects are composed and created.
    * */
}
