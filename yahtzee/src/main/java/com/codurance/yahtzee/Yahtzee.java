package com.codurance.yahtzee;

import com.codurance.yahtzee.scorer.Scorer;
import com.codurance.yahtzee.scorer.ScoringCategory;

public class Yahtzee {
    private final DiceCup diceCup;

    public Yahtzee(DiceCup diceCup) {

        this.diceCup = diceCup;
    }

    public int[] roll(int numberOfDice) {
        return diceCup.roll(numberOfDice);
    }

    public int scoreWith(ScoringCategory scoringCategory, int[] diceRolls) {
        return Scorer.forCategory(scoringCategory).score(diceRolls);
    }
}
