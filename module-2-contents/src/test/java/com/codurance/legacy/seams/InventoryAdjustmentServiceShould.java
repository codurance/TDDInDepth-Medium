package com.codurance.legacy.seams;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InventoryAdjustmentServiceShould {
    private InventoryAdjustmentService inventoryAdjustmentService;

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

    public class TestInventoryAdjustmentService extends InventoryAdjustmentService {
        @Override
        protected Item getItem(ItemAdjustment adjustment) throws Throwable {
            return null;
        }
    }
}

