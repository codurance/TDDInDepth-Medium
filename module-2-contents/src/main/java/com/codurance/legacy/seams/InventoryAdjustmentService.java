package com.codurance.legacy.seams;

import java.util.List;

public class InventoryAdjustmentService {
    public void adjustInventory(List<ItemAdjustment> adjustments) throws Throwable {
        for (ItemAdjustment adjustment : adjustments) {
            Item item = InventoryDatabase.getItem(adjustment.getItemId());

            if (item == null) {
                throw new ItemNotFoundException("Item not found: " + adjustment.getItemId());
            }

            double price = PricingService.getPriceForItem(item);

            if (adjustment.getQuantity() < 0) {
                item.reduceStock(-adjustment.getQuantity(), price);
            } else {
                item.increaseStock(adjustment.getQuantity(), price);
            }

            InventoryDatabase.updateItem(item);
        }
    }
}
