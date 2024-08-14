package com.codurance.testableCode.globalState.testable;

public class CreditCardProcessor {

    private final ChargeQueue chargeQueue;

    public CreditCardProcessor(ChargeQueue chargeQueue) {
        this.chargeQueue = chargeQueue;
    }

    public void process(CreditCard creditCard, int amount) {
        chargeQueue.add(creditCard, amount);
    }
}
