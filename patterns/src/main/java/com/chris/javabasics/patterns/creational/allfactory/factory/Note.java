package com.chris.javabasics.patterns.creational.allfactory.factory;

public class Note {
    /*
          factory pattern belongs to the group of creational patterns

          Its purpose is to create an instance of an object
               without exposing the implementation details of how to create such objects by using a factory instead

          Creating objects based on input with the factory method pattern
          The primary purpose of this pattern is to centralize the class’s instantiation of a specific type.
          The pattern leaves the decision to create the exact class type up to the client at runtime.

          Motivation
          The factory method pattern enforces the separation of code and its responsibility for creating new  instances of the class,
                that is, such a method provides the expected result.
          The factory hides an application  class hierarchy based on a generics abstraction and introduces a common interface.
          It transparently separates the instantiation logic from the rest of the code.
          By introducing the common interface, the client gains the freedom to decide on a particular class instance at runtime.
          The pattern is often used in the early stages of an application because it is simple to refactor and provides a high level of clarity.

           JDK
           Each implementation of Set, List, and Map provides overloaded of factory method to create an instance.

            in the java.util package of the java.base module
           The Collections class is a utility class. It contains several factory methods for creating specific collections, such as a list of individual items, a map, or a set.

             in the java.util.concurrent package of the java.base module
           The Executors utility class defines static methods such as newFixedThreadPool

            The most important limitation is that it can only be used for a specific family of objects.
            This means that all classes must maintain similar properties or common ground.
            The deviation from the base class of a class can introduce a dramatic strong coupling between the code and the application.
      */
}
