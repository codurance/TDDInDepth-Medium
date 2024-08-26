package com.codurance.legacy.seams;

import jdk.jshell.spi.ExecutionControl;

public class InventoryDatabase {
    public static Item getItem(String itemId) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Cannot access to database from tests.");
    }

    public static void updateItem(Item item) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Cannot access to database from tests.");
    }
}
