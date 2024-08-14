package com.codurance.testableCode.lawOfDemeter.testable;

public record Price(int value) {
    public static Price sum(Price first, Price second) {
        return new Price(first.value + second.value);
    }

    public Price multiplyBy(double factor) {
        return new Price((int) (value * factor));
    }

    public Price subtract(Price price) {
        if (price.value > value) {
            throw new IllegalArgumentException("Price cannot be negative");
        }

        return new Price(value - price.value);
    }
}
