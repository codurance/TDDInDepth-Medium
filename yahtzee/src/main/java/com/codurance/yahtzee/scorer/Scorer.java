package com.codurance.yahtzee.scorer;

public abstract class Scorer {

    public static Scorer forCategory(ScoringCategory scoringCategory) {
        return switch (scoringCategory) {
            case ScoringCategory.ONES -> new OnesScorer();
            case ScoringCategory.TWOS -> new TwosScorer();
            case ScoringCategory.THREES -> new ThreesScorer();
            case ScoringCategory.FOURS -> new FoursScorer();
            case ScoringCategory.FIVES -> new FivesScorer();
            case ScoringCategory.SIXES -> new SixesScorer();
        };
    }

    public abstract int score(int[] diceRolls);

}
