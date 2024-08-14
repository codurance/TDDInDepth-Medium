package com.codurance.testableCode.globalState.untestable;

public class ChargeQueue {
    private static ChargeQueue instance;

    public static void start() {
        instance = new ChargeQueue();
    }

    public static ChargeQueue getInstance() {
        return instance;
    }

    public void add(CreditCard creditCard, int amount) {
        Database.getInstance().save(creditCard, amount);
    }
}
