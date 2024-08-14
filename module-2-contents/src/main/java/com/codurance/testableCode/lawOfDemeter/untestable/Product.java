package com.codurance.testableCode.lawOfDemeter.untestable;


public class Product {
    private final String name;
    private final double price;
    private final ProductCategory category;

    public Product(String name, double price, ProductCategory category) {

        this.name = name;
        this.price = price;
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public ProductCategory getCategory() {
        return category;
    }
}
