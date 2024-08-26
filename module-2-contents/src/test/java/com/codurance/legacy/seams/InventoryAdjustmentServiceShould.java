package com.codurance.legacy.seams;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InventoryAdjustmentServiceShould {
    private TestInventoryAdjustmentService inventoryAdjustmentService;

    @BeforeEach
    protected void setup() {
        inventoryAdjustmentService = new TestInventoryAdjustmentService();
    }

    @Test
    public void throwItemNotFoundExceptionWhenThereIsNoItemInAdjustments() {

        List<ItemAdjustment> adjustments = Arrays.asList(
            new ItemAdjustment("test1", 5)
        );

        assertThrows(ItemNotFoundException.class, () -> {
            inventoryAdjustmentService.adjustInventory(adjustments);
        });
    }

    @Test
    public void reduceStockFromInventoryGivenAnAdjustment() throws Throwable {

        Item item = new Item(13, 130);
        inventoryAdjustmentService.setItem(item);

        List<ItemAdjustment> adjustments = Arrays.asList(
            new ItemAdjustment("test1", -5)
        );

        inventoryAdjustmentService.adjustInventory(adjustments);

        assertEquals(8, item.getQuantity());
        assertEquals(80, item.getPrice());
    }

    @Test
    public void increaseStockFromInventoryGivenAnAdjustment() throws Throwable {

        Item item = new Item(13, 130);
        inventoryAdjustmentService.setItem(item);

        List<ItemAdjustment> adjustments = Arrays.asList(
            new ItemAdjustment("test1", 5)
        );

        inventoryAdjustmentService.adjustInventory(adjustments);

        assertEquals(18, item.getQuantity());
        assertEquals(180, item.getPrice());
    }

    public class TestInventoryAdjustmentService extends InventoryAdjustmentService {
        private Item item = null;

        private void setItem(Item item) {

            this.item = item;
        }
        @Override
        protected Item getItem(ItemAdjustment adjustment) {
            return item;
        }

        @Override
        protected double getPriceForItem(Item item) {
            return 10;
        }

        @Override
        protected void updateItem(Item item) {

        }
    }
}

