package com.codurance.testableCode.connascence.refactored;

public class CreditCardBuilder {
    private String cardNumber;
    private String cardName;
    private String cardExpiry;
    private String cardCVC;

    public static CreditCardBuilder aCreditCard() {
        return new CreditCardBuilder();
    }

    public CreditCardBuilder withCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public CreditCardBuilder withCardName(String cardName) {
        this.cardName = cardName;
        return this;
    }

    public CreditCardBuilder withCardExpiry(String cardExpiry) {
        this.cardExpiry = cardExpiry;
        return this;
    }

    public CreditCardBuilder withCardCVC(String cardCVC) {
        this.cardCVC = cardCVC;
        return this;
    }

    public CreditCard build() {
        return new CreditCard(cardNumber, cardName, cardExpiry, cardCVC);
    }
}