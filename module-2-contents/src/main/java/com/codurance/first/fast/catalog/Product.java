package com.codurance.first.fast.catalog;

public class Product {
    private final String name;
    private final int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int price() {
        return price;
    }
}
