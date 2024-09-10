package com.codurance.yahtzee.scorer;

import java.util.Arrays;

public class FivesScorer extends Scorer {

    @Override
    public int score(int[] diceRolls) {
        return Arrays.stream(diceRolls).filter(dice -> dice == 5).sum();
    }
}
