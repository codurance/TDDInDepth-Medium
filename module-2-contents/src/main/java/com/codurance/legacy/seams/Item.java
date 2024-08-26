package com.codurance.legacy.seams;

public class Item {
    private int quantity;
    private double price;

    Item(int quantity, double price) {

        this.quantity = quantity;
        this.price = price;
    }
    public void reduceStock(int quantity, double price) {
        this.quantity -= quantity;
        this.price -= price * quantity;
    }

    public void increaseStock(int quantity, double price) {
        this.quantity += quantity;
        this.price += price * quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}
