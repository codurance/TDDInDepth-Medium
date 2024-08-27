package com.codurance.sociableVsSolitary.solitary;

import com.codurance.sociableVsSolitary.DiscountCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiscountCalculatorShould {
    @Test
    public void calculateDiscount() {
        DiscountCalculator discountCalculator = new DiscountCalculator();

        double discount = discountCalculator.calculateDiscount(100.0);

        assertEquals(10.0, discount);
    }
}
