package com.codurance.first.isolated.cart;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartShould {
    @Test
    public void shouldAddItemToCart() {
        ShoppingCart cart = new ShoppingCart();
        Item item = new Item("Apple", 1.00);

        cart.addItem(item);

        assertEquals(1, cart.getItems().size());
        assertEquals("Apple", cart.getItems().get(0).getName());
    }

    @Test
    public void shouldRemoveItemFromCart() {
        ShoppingCart cart = new ShoppingCart();
        Item item = new Item("Apple", 1.00);
        cart.addItem(item);

        cart.removeItem(item);

        assertEquals(0, cart.getItems().size());
    }
}
