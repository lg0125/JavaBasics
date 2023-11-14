package com.chris.javabasics.patterns.behavioral.template;

public class Note {
    /*
    * Standardizing processes with the template pattern
    *
    * The template method pattern unifies the generalization of intensive actions with a templating approach.
    *
    * Motivation
    * The template method pattern is based on identifying similarly used steps.
    *
    * These steps define the skeleton of an algorithm. Each operation can defer its steps to specific subclasses.
    *
    * The template method introduces subclasses to redefine certain parts of an algorithm without changing its structure.
    *
    * A template can be used to execute the internal methods in the desired order
    *
    * JDK
    * Java uses input or output byte streams defined by the I/O API located in the java.base module and the java.io package.
    * The InputStream class contains an overloaded read method that represents a byte-handling template.
    * It’s a similar approach to the OutputStream class defining an overloaded write method.
    *
    * Another use of the template pattern can be found in the Collection framework, which resides in the same module and the java.util package.
    * The abstract AbstractList, AbstractSet, and AbstractMap classes implement the indexOf and lastIndexOf methods with different templates –
    *      for example, AbstractList uses ListIterator, in comparison to the common Iterator interface implementation.
    * */
}
