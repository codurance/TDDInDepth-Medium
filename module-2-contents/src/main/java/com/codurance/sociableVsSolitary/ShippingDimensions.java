package com.codurance.sociableVsSolitary;

public class ShippingDimensions {
    private final double height;
    private final double width;
    private final double depth;
    private final double weight;

    public ShippingDimensions(double height, double width, double depth, double weight) {
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.weight = weight;
    }

    public double getLongestSide(ShippingDimensions shipmentDetails) {
        return Math.max(shipmentDetails.height,
            Math.max(shipmentDetails.width, shipmentDetails.depth));
    }

    public double getWeight() {
        return weight;
    }

    public double calculateVolume() {
        return height * width * depth;
    }

}
