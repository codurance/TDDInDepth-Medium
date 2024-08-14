package com.codurance.testableCode.overloadedConstructors.untestable;

public class OrderRepository {
    public OrderRepository(DatabaseConnection databaseConnection) {
    }

    public void saveOrder(Order order) {

    }
}
