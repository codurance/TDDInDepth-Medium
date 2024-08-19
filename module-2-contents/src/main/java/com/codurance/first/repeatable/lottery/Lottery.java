package com.codurance.first.repeatable.lottery;

public class Lottery {
    private final RandomNumberGenerator numberGenerator;

    public Lottery(RandomNumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public int createTicket() {
        return numberGenerator.generateThreeDigitsNumber();
    }

    public int winningNumber() {
        int unit = numberGenerator.generateSingleDigitNumber();
        int ten = numberGenerator.generateSingleDigitNumber();
        int hundred = numberGenerator.generateSingleDigitNumber();

        return Integer.parseInt(
            String.format("%d%d%d", hundred, ten , unit)
        );
    }
}
