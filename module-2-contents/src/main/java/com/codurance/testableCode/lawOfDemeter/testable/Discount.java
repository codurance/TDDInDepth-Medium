package com.codurance.testableCode.lawOfDemeter.testable;

public class Discount {
    private final double discount;

    public Discount(double discount) {
        this.discount = discount;
    }

    public Price apply(Price price) {
        return price.subtract(price.multiplyBy(discount));
    }
}
