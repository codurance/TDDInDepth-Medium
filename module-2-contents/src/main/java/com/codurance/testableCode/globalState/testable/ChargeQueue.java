package com.codurance.testableCode.globalState.testable;

public class ChargeQueue {
    private final Database database;

    public ChargeQueue(Database database) {
        this.database = database;
    }

    public void add(CreditCard creditCard, int amount) {
        database.save(creditCard, amount);
    }
}
