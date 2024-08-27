package com.codurance.sociableVsSolitary.solitary;

import com.codurance.sociableVsSolitary.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OrderServiceShould {

    private ShippingCalculator shippingCalculator;
    private DiscountCalculator discountCalculator;
    private OrderService orderService;

    @BeforeEach
    void setUp() {
        shippingCalculator = mock(ShippingCalculator.class);
        discountCalculator = mock(DiscountCalculator.class);
        orderService = new OrderService(shippingCalculator, discountCalculator);
    }

    @Test
    public void calculateTotalWithShippingCostAndDiscount() {
        ShippingDimensions dimensions = new ShippingDimensions(40, 25, 10, 3);
        double price = 100.0;
        Product product = new Product("Laptop", price, dimensions);
        when(discountCalculator.calculateDiscount(price)).thenReturn(10.0);
        when(shippingCalculator.calculateShippingCost(dimensions)).thenReturn(5.0);

        double calculateTotal = orderService.calculateTotal(product);

        assertEquals(95.0, calculateTotal);
    }

}
