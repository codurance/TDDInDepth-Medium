public abstract class Scorer {

    public static Scorer forCategory(ScoringCategory scoringCategory) {
        return switch (scoringCategory) {
            case ONES -> new OnesScorer();
            case TWOS -> new TwosScorer();
            case THREES -> new ThreesScorer();
            case FOURS -> new FoursScorer();
            case FIVES -> new FivesScorer();
        };
    }

    public abstract int score(int[] diceRolls);

}
