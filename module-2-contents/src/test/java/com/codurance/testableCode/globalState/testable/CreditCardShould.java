package com.codurance.testableCode.globalState.testable;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class CreditCardShould {
    @Test
    public void beTestable() {
        Database myConnection = new Database("myConnection");
        ChargeQueue chargeQueue = new ChargeQueue(myConnection);
        CreditCardProcessor creditCardProcessor = new CreditCardProcessor(chargeQueue);
        CreditCard creditCard = new CreditCard("1234567812345678", "John Doe", "12/26", creditCardProcessor);

        creditCard.charge(100);

        // assert something
    }

    @Test
    public void beTestableInIsolation() {
        CreditCardProcessor creditCardProcessor = mock(CreditCardProcessor.class);
        // if you end up having to inject too many dependencies, it is because you already had those dependencies, they just weren't explicit
        CreditCard creditCard = new CreditCard("1234567812345678", "John Doe", "12/26", creditCardProcessor);

        creditCard.charge(100);

        verify(creditCardProcessor).process(creditCard, 100);
    }
}