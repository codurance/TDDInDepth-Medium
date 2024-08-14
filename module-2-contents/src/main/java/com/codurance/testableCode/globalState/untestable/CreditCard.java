package com.codurance.testableCode.globalState.untestable;

public class CreditCard {
    public CreditCard(String number, String name, String expiry) {
    }

    public void charge(int amount) {
        CreditCardProcessor.getInstance().process(this, amount);
    }
}
