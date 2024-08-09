package com.codurance;

public class Game {

    private int pins = 0;

    public void roll(int pins) {
        this.pins = pins;
    }

    public int score() {
        return pins;
    }
}
