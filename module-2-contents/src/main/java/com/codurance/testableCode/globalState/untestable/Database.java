package com.codurance.testableCode.globalState.untestable;

public class Database {
    private static Database database;
    private final String connectionString;

    private Database(String connectionString) {
        this.connectionString = connectionString;
    }

    public static void connect(String connectionString) {
        database = new Database(connectionString);
    }

    public static Database getInstance() {
        return database;
    }


    public void save(CreditCard creditCard, int amount) {
        System.out.println("Saving to database: " + creditCard + " amount: " + amount);
    }
}
