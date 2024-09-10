package com.codurance.yahtzee;

public class Yahtzee {
    private final DiceCup diceCup;
    private final Display display;

    public Yahtzee(DiceCup diceCup, Display display) {

        this.diceCup = diceCup;
        this.display = display;
    }

    public void roll(int numberOfDice) {
        int[] roll = diceCup.roll(numberOfDice);
        display.displayRoll(roll);
    }
}
