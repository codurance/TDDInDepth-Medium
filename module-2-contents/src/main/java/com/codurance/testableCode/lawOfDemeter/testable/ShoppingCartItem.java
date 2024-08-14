package com.codurance.testableCode.lawOfDemeter.testable;

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

    public Price getPriceAfterDiscount() {
        return product.getDiscountedPrice().multiplyBy(quantity);

    }
}
