package com.codurance.legacy.seams;

import jdk.jshell.spi.ExecutionControl;

import java.util.List;

public class InventoryAdjustmentService {
    public void adjustInventory(List<ItemAdjustment> adjustments) throws Throwable {
        for (ItemAdjustment adjustment : adjustments) {
            Item item = getItem(adjustment);

            if (item == null) {
                throw new ItemNotFoundException("Item not found: " + adjustment.getItemId());
            }

            double price = getPriceForItem(item);

            if (adjustment.getQuantity() < 0) {
                item.reduceStock(-adjustment.getQuantity(), price);
            } else {
                item.increaseStock(adjustment.getQuantity(), price);
            }

            updateItem(item);
        }
    }

    protected void updateItem(Item item) throws ExecutionControl.NotImplementedException {
        InventoryDatabase.updateItem(item);
    }

    protected double getPriceForItem(Item item) throws ExecutionControl.NotImplementedException {
        return PricingService.getPriceForItem(item);
    }

    protected Item getItem(ItemAdjustment adjustment) throws Throwable {
        return InventoryDatabase.getItem(adjustment.getItemId());
    }
}
