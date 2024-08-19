package com.codurance.first.fast.catalog;

import java.util.List;

public class ExternalAPIWarehouse implements Warehouse{
    @Override
    public List<Product> getProducts() {
        return List.of();
    }
}
