package com.codurance.sociableVsSolitary;

public class OrderService {

    private final ShippingCalculator shippingCalculator;
    private final DiscountCalculator discountCalculator;

    public OrderService(ShippingCalculator shippingCalculator, DiscountCalculator discountCalculator) {
        this.shippingCalculator = shippingCalculator;
        this.discountCalculator = discountCalculator;
    }

    public double calculateTotal(Product product) {
        double discount = discountCalculator.calculateDiscount(product.getPrice());
        double shippingCost = shippingCalculator.calculateShippingCost(product.getDimensions());
        return product.getPrice() - discount + shippingCost
            ;
    }
}
