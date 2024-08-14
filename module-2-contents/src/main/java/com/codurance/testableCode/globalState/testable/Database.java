package com.codurance.testableCode.globalState.testable;

public class Database {
    private final String connectionString;

    public Database(String connectionString) {
        this.connectionString = connectionString;
    }

    public void save(CreditCard creditCard, int amount) {
        System.out.println("Saving to database: " + creditCard + " amount: " + amount);
    }
}
