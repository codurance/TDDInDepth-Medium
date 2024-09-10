package com.codurance.yahtzee;

public class Yahtzee {
    private final DiceCup diceCup;

    public Yahtzee(DiceCup diceCup) {

        this.diceCup = diceCup;
    }

    public void roll(int numberOfDice) {
        diceCup.roll(numberOfDice);
    }
}
