package com.codurance.testableCode.lawOfDemeter.testable;

import java.util.List;

public class ShoppingCart {
    private final List<ShoppingCartItem> items;

    public ShoppingCart(List<ShoppingCartItem> items) {

        this.items = items;
    }

    public Price getTotalWithDiscount() {
        return items.stream()
            .map(ShoppingCartItem::getPriceAfterDiscount)
            .reduce(Price::sum)
            .orElse(new Price(0));
    }
}
