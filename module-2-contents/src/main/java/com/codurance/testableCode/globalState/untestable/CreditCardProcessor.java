package com.codurance.testableCode.globalState.untestable;

public class CreditCardProcessor {
    private static CreditCardProcessor creditCardProcessor;

    private CreditCardProcessor() {
    }

    public static void init() {
        creditCardProcessor = new CreditCardProcessor();
    }

    public static CreditCardProcessor getInstance() {
        return creditCardProcessor;
    }

    public void process(CreditCard creditCard, int amount) {
        ChargeQueue.getInstance().add(creditCard, amount);
    }
}
