package com.codurance.sociableVsSolitary.sociable;

import com.codurance.sociableVsSolitary.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderServiceShould {

    private OrderService orderService;

    @BeforeEach
    void setUp() {
        orderService = new OrderService(new ShippingCalculator(), new DiscountCalculator());
    }

    @Test
    public void shouldCalculateShippingCostWithDiscount() {
        ShippingDimensions dimensions = new ShippingDimensions(40, 25, 10, 3);
        Product product = new Product("Laptop", 100.0, dimensions);

        double calculateTotal = orderService.calculateTotal(product);

        assertEquals(99.15, calculateTotal);
    }
}
