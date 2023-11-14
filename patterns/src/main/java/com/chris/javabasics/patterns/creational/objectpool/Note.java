package com.chris.javabasics.patterns.creational.objectpool;

public class Note {
    /*
    * The object pool pattern instantiates ready-to-use objects and limits their initialization time.
    *   The required instances can be recreated on demand.
    * A pool of objects can represent a base of conditions on which new instances could be created, or limit their creation.
    *
    * Motivation
    *   the object pool provides an encapsulated solution for managing application or client performance by serving an already initialized object ready for use.
    *
    *   The pattern separates the build logic from the business code and helps manage the resource and performance aspects of the application.
    *       It may not only help with an object’s life cycle but also with validation when it is created or destroyed.
    *
    * JDK
    *   the ExecutorService interface found in the java.util.concurrent package
    *       and the implementation provided by the Executors class of the util factory that handles the appropriate executor instances,
    *           for example, the newScheduledThreadPool method.
    * */
}
