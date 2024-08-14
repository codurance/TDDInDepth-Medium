package com.codurance.testableCode.globalState.untestable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardShould {
    @Test
    public void beDifficultToTest() {
        CreditCard creditCard = new CreditCard("1234567812345678", "John Doe", "12/26");

        creditCard.charge(100);
    }
}