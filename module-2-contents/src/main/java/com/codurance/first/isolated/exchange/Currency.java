package com.codurance.first.isolated.exchange;

public class Currency {
    private final String name;
    private final double exchangeRate;

    public Currency(String name, double exchangeRate) {
        this.name = name;
        this.exchangeRate = exchangeRate;
    }

    public double exchangeRate() {
        return exchangeRate;
    }

    public String name() {
        return name;
    }
}
