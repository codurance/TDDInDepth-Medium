package com.codurance.first.fast.catalog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CatalogShould {
    private Catalog catalog;
    private Warehouse warehouse;

    @BeforeEach
    public void setup() {
        warehouse = mock(Warehouse.class);
        catalog = new Catalog(warehouse);
    }

    @Test
    public void show_a_product_list_ordered_by_lower_price() {
        // Mock products list
        List<Product> mockProducts = new ArrayList<>();
        mockProducts.add(new Product("Product 1", 50));
        mockProducts.add(new Product("Product 2", 100));
        mockProducts.add(new Product("Product 3", 30));
        mockProducts.add(new Product("Product 4", 3));

        // Mock the response from warehouse.getProducts
        when(warehouse.getProducts()).thenReturn(mockProducts);

        List<Product> products = catalog.byLowerPrice();

        assertEquals(4, products.size());
        assertEquals(3, products.get(0).price());
        assertEquals(100, products.get(3).price());

        verify(warehouse).getProducts();
    }
}
