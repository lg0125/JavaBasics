package com.chris.javabasics.patterns.behavioral.strategy.v1;

public class ExpeditedShipping implements ShippingStrategy {
    private final boolean signatureRequired;

    public ExpeditedShipping(boolean signatureRequired) {
        this.signatureRequired = signatureRequired;
    }

    @Override
    public void ship(Parcel parcel) {
        System.out.printf(
                "Shipping Parcel with '%s' (signature=%s)%n",
                getClass().getSimpleName(),
                this.signatureRequired
        );
    }
}
