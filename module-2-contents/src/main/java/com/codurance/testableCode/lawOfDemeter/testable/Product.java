package com.codurance.testableCode.lawOfDemeter.testable;

public class Product {
    private final String name;
    private final Price price;
    private final ProductCategory category;

    public Product(String name, Price price, ProductCategory category) {

        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Price getDiscountedPrice() {
        return category.getDiscount().apply(price);

    }
}
