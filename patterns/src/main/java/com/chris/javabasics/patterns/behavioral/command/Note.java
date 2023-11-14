package com.chris.javabasics.patterns.behavioral.command;

public class Note {
    /*
    * Turning information into action with the command pattern
    *
    * The command pattern encapsulates the triggered event as an object that allows the client to act.
    *
    * Motivation
    * The command pattern dictates which instances of the command interface perform which actions on the receiver client.
    *
    * A command object can be parameterized to define an action in greater detail.
    *
    * The commands can include a callback function to notify others of the occurrence of an event.
    *
    * Sometimes, commands can be thought of as object-oriented replacements for callback functions.
    *
    * A newly created command object can have different dynamics depending on the event that initiated it.
    *
    * The client can react to it according to an already scheduled scenario.
    *
    * JDK
    * Nice examples are provided in the JDK by the Callable and Runnable interfaces from the java.base module and the java.util.concurrent package.
    * The implementation of each interface is scheduled for execution based on a known scenario.
    *
    * The command object is separate from the logic and may contain additional valuable information.
    * A command has its own lifecycle and makes it easy to implement callback functions that can trigger another event.
    * */
}
