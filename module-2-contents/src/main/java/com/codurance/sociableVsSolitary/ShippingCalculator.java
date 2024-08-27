package com.codurance.sociableVsSolitary;

public class ShippingCalculator {

    private final double BASE_RATE = 5.0;
    private final double SIZE_FACTOR = 0.1;
    private final double WEIGHT_FACTOR = 0.05;

    public double calculateShippingCost(ShippingDimensions dimensions) {
        double volumetricWeight = calculateVolumetricWeight(dimensions);
        double chargeableWeight = Math.max(dimensions.getWeight(), volumetricWeight);

        double sizeCost = calculateSizeCost(dimensions);
        double weightCost = calculateWeightCost(chargeableWeight);

        return BASE_RATE + sizeCost + weightCost;
    }

    private double calculateVolumetricWeight(ShippingDimensions shipmentDetails) {
        return shipmentDetails.calculateVolume() / 5000;
    }

    private double calculateSizeCost(ShippingDimensions shipmentDetails) {
        return shipmentDetails.getLongestSide(shipmentDetails) * SIZE_FACTOR;
    }

    private double calculateWeightCost(double chargeableWeight) {
        return chargeableWeight * WEIGHT_FACTOR;
    }
}
