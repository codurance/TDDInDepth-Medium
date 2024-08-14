package com.codurance.testableCode.lawOfDemeter.untestable;

public class Checkout {
    private final ShoppingCart shoppingCart;

    public Checkout(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public double getTotalPrice() {
        return shoppingCart.getItems()
            .stream()
            .mapToDouble(item -> item
                .getProduct()
                .getCategory()
                .getDiscount()
                .apply(item
                    .getProduct()
                    .getPrice() * item.getQuantity()))
            .sum();
    }
}

