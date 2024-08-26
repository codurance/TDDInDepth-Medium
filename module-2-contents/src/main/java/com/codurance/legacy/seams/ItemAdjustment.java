package com.codurance.legacy.seams;

public class ItemAdjustment {
    private String itemId;
    private int quantity;

    ItemAdjustment(String itemId, int quantity) {
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public String getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }
}
