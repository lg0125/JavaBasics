package com.chris.javabasics.patterns.behavioral.strategy.v1;

public class Main {
    public static void main(String... args) {

        var service = new ShippingService() {};
        var parcel = new Parcel();

        var strategy = new ExpeditedShipping(true);
        service.ship(parcel, strategy);

        var strategy2 = new StandardShipping();
        service.ship(parcel, strategy2);
    }
}
