package com.codurance.testableCode.cohesion.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartShould {

    @Test
    public void calculateTotalPrice() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(new Product("Tablet", 100.0), 2);
        shoppingCart.addItem(new Product("Television", 300.0), 1);

        double totalPrice = shoppingCart.calculateTotalPrice();

        assertEquals(500.00, totalPrice);
    }
}