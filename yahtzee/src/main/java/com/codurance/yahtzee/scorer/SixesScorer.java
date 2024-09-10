package com.codurance.yahtzee.scorer;

import java.util.Arrays;

public class SixesScorer extends Scorer {

    @Override
    public int score(int[] diceRolls) {
        return Arrays.stream(diceRolls).filter(dice -> dice == 6).sum();
    }
}

