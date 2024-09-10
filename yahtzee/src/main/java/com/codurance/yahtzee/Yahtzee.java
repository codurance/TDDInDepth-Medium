package com.codurance.yahtzee;

public class Yahtzee {
    private final DiceCup diceCup;

    public Yahtzee(DiceCup diceCup) {

        this.diceCup = diceCup;
    }

    public int[] roll(int numberOfDice) {
        return diceCup.roll(numberOfDice);
    }
}
