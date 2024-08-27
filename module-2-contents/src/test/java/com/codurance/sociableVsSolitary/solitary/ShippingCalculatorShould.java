package com.codurance.sociableVsSolitary.solitary;

import com.codurance.sociableVsSolitary.ShippingCalculator;
import com.codurance.sociableVsSolitary.ShippingDimensions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShippingCalculatorShould {
    @Test
    public void calculateShippingCost() {
        ShippingCalculator shippingCalculator = new ShippingCalculator();
        ShippingDimensions dimensions = new ShippingDimensions(40, 25, 10, 3);

        double shippingCost = shippingCalculator.calculateShippingCost(dimensions);

        assertEquals(9.15, shippingCost);
    }
}
