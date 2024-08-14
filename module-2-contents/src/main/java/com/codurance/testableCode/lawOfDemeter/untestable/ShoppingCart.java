package com.codurance.testableCode.lawOfDemeter.untestable;

import java.util.List;

public class ShoppingCart {
    private final List<ShoppingCartItem> items;

    public ShoppingCart(List<ShoppingCartItem> items) {

        this.items = items;
    }

    public List<ShoppingCartItem> getItems() {
        return List.copyOf(items);
    }
}
