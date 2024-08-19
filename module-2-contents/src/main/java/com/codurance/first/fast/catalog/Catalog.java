package com.codurance.first.fast.catalog;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Catalog {
    private final Warehouse warehouse;

    public Catalog(Warehouse warehouse) {

        this.warehouse = warehouse;
    }

    public List<Product> byLowerPrice() {
        return warehouse.getProducts()
            .stream()
            .sorted(Comparator.comparing(Product::price))
            .collect(Collectors.toList());
    }
}
