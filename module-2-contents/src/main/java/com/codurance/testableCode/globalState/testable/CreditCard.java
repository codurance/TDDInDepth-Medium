package com.codurance.testableCode.globalState.testable;

public class CreditCard {
    private CreditCardProcessor creditCardProcessor;

    public CreditCard(String number, String name, String expiry, CreditCardProcessor creditCardProcessor) {
        this.creditCardProcessor = creditCardProcessor;
    }

    public void charge(int amount) {
        creditCardProcessor.process(this, amount);
    }
}
