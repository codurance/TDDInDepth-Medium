package com.codurance.testableCode.lawOfDemeter.untestable;

public class ProductCategory {
    private final String name;
    private Discount discount;

    public ProductCategory(String name, Discount discount) {
        this.name = name;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public Discount getDiscount() {
        return discount;
    }
}
