package com.chris.javabasics.patterns.behavioral.strategy.v1;

public interface ShippingService {
    default void ship(Parcel parcel, ShippingStrategy strategy) {
        strategy.ship(parcel);
    }
}
