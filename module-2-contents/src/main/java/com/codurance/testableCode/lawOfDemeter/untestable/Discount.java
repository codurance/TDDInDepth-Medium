package com.codurance.testableCode.lawOfDemeter.untestable;

public class Discount {
    private final double discount;

    public Discount(double discount) {
        this.discount = discount;
    }

    public double apply(double price) {
        return price - (price * discount);
    }
}
