package com.codurance.testableCode.cohesion.tdd;

public class Item {
    private final Product product;
    private final int quantity;

    public Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double total() {
        return product.price() * quantity;
    }
}
