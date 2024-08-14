package com.codurance.testableCode.lawOfDemeter.untestable;

public class ShoppingCartItem {
    private final Product product;
    private final int quantity;

    public ShoppingCartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
