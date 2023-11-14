package com.chris.javabasics.patterns.structral.composite;

public class Note {
    /*
    * The composite pattern is a remarkable solution
    *   for handling objects uniformly while arranging them in a tree structure,
    *   which simplifies access to instances.
    *
    * Motivation
    *   Grouping objects around the underlying business logic is a powerful approach.
    *   A composite design pattern outlines a way to achieve such a state.
    *
    *   Since each member of the group is treated uniformly, it is possible to create hierarchical tree structures and part-whole hierarchies.
    *   It helps to establish the logical relationships of the application and the composition of the desired objects.
    *
    * JDK
    *   In the JDK, the composite pattern can be found in the java.base module, the java.util package, and the Properties class.
    *   The Properties class implements the Map interface through its Hashtable implementation, and
    *       also contains a ConcurrentHashMap instance to store the property values internally.
    *
    *   Although the Properties class’s put operation remains synchronized due to the Hashtable implementation,
    *       the get operation does not, as it is simple to read into the concurrent map.
    *
    * The composite pattern allows the representation of the composition of a class in granular detail.
    *       It takes  into account the smaller parts of the composite by creating part-whole hierarchies.
    * While this provides advantages because each part is treated uniformly, it can lead to ignoring differences between parts.
    *       On the other hand, the composite pattern holds all the involved parts together in a transparent form.
    * */
}
