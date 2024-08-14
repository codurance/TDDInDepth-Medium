package com.codurance.testableCode.lawOfDemeter.testable;

public class Checkout {
    private final ShoppingCart shoppingCart;

    public Checkout(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Price getTotalPrice() {
        return shoppingCart.getTotalWithDiscount();
    }
}

