package com.chris.javabasics.patterns.creational.lazyinitialization;

public class Note {
    /*
    * This pattern’s purpose is to defer an instance of the desired class instance until the client actually requests it.
    *
    * Motivation
    *   the JVM allocated a defined, specific size of memory reserved for the heap
    *   When the heap is exhausted and the JVM is unable to allocate any new object, it causes an out of memory error.
    *
    * JDK
    *   Lazy initialization can be demonstrated using the example of dynamic loading by ClassLoader of  classes that were not linked at runtime when the application was started.
    *
    *   Classes can be loaded eagerly or deferred by the class policy.
    *
    *   Certain classes, such as ClassNotFoundException, are loaded implicitly through the java.base module.
    *
    *   They support the class implementation located in the java.lang package and its forName method.
    *
    *   The implementation of the method is provided by an internal API.
    *
    *   A lazy initiated class may be the reason the application requires a warm-up time.
    *
    *   For example, Enum classes are a special type of static final classes that act as constants and are loaded eagerly.
    * */
}
