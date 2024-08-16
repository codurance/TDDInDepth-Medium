package com.codurance.testableCode.cohesion.tdd;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Item> items = new ArrayList<>();

    public void addItem(Product product, int quantity) {
        items.add(new Item(product, quantity));
    }

    public double calculateTotalPrice() {
        return items.stream()
                .mapToDouble(Item::total)
                .sum();
    }
}
