package com.codurance.legacy.seams;

import jdk.jshell.spi.ExecutionControl;

public class PricingService {
    public static double getPriceForItem(Item item) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Cannot access external services from tests.");
    }
}
