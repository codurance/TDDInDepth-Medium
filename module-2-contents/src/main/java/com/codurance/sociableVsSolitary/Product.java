package com.codurance.sociableVsSolitary;

public class Product {
    private final String name;
    private final double price;
    private final ShippingDimensions dimensions;

    public Product(String name, double price, ShippingDimensions dimensions) {
        this.name = name;
        this.price = price;
        this.dimensions = dimensions;
    }

    public double getPrice() {
        return price;
    }

    public ShippingDimensions getDimensions() {
        return dimensions;
    }
}
