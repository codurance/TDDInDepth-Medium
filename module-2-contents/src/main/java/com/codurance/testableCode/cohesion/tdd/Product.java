package com.codurance.testableCode.cohesion.tdd;

public class Product {
    private final String name;
    private final double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double price() {
        return price;
    }
}
