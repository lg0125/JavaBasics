package com.chris.javabasics.patterns.behavioral.caching;

public class Note {
    /*
    * Limiting expensive initialization using the caching
    *
    * Motivation
    * The caching pattern supports element reuse.
    *
    * It does not create a new element on demand – instead, it reuses an already-created element stored in the cache.
    *
    * It stores frequently needed data in fast-access storage for increased performance.
    *
    * Reading data from the cache is faster than instantiating a new entity given the low complexity of fetching the required element.
    *
    * JDK
    *  The java.base module and its java.lang package provide wrapper classes for primitive types.
    *
    *  The valueOf method for double, float, integer, byte,
    *       or character types uses a caching mechanism for frequently requested values
    *       to reduce memory space and improve performance.
    *
    *
    * */
}
