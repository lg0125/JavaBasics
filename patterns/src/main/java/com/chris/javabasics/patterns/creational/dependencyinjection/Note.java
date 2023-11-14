package com.chris.javabasics.patterns.creational.dependencyinjection;

public class Note {
    /*
    * This pattern separates the initialization of the class (that acts as a service) from the client (that uses the service).
    *
    * The dependency injection pattern is widely used where there is a need
    *   to separate the implementation of a particular object (service)
    *   from the target object (client) that uses its exposed services, methods, and the like.
    *
    * Services are available when a client instance is to be created.
    *
    * The pattern allows you to eliminate any hardcoded dependencies.
    *
    * These services are instantiated outside the client creation process.
    *
    * There are three ways that dependency injection can be implemented:
    * (1) Constructor dependency injection:
    *       Intended services are made available to the client through the initialization of the constructor.
    * (2) Injection method:
    *       The client exposes the method normally through an interface.
    *       Such a  method supplies dependencies to the client.
    *       The supplier object uses a method to inject the service(s) into the client.
    * (3) Field dependency injection:
    *       This type of injection is done using a setup-like method.
    *       These setters refer to the respective field held by the client.
    *       The client can also expose the field as a public property.
    *
    * JDK
    *   A good example of using the dependency injection pattern is the ServiceLoader utility class.
    *   It can be found in the java.base module and its java.util package.
    *   The ServiceLoader instance tries to find services during the application startup at runtime.
    *   A service is considered to be represented by a well-specified interface that is implemented by the relevant service provider or providers.
    *   The application code is able to distinguish the desired provider at runtime.
    *
    * The dependency injection pattern ensures that the client does not know about the instantiation of the used service.
    *
    * The client has access to the service through the common interfaces. It makes the code base better testable.
    *
    * It also simplifies the code base testability. Dependency injection is a widely used pattern by various frameworks, such as Spring and Quarkus.
    * Quarkus uses the Jakarta Dependency Injection specification.
    *
    * The dependency injection pattern conforms to the SOLID and API object-oriented programming principles as it provides the abstraction of interfaces.
    *
    * The code does not depend on the implementation but communicates with the services through the interfaces.
    *
    * The dependency injection pattern enforces a DRY principle as it is not required to continually initiate a service.
    *
    * */
}
