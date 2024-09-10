package com.codurance.yahtzee.scorer;

import java.util.Arrays;

public class FoursScorer extends Scorer {

    @Override
    public int score(int[] diceRolls) {
        return Arrays.stream(diceRolls).filter(dice -> dice == 4).sum();
    }
}
