import java.util.Arrays;

public class Scorer {

    private final ScoringCategory scoringCategory;

    protected Scorer(ScoringCategory scoringCategory) {
        this.scoringCategory = scoringCategory;
    }

    public static Scorer forCategory(ScoringCategory scoringCategory) {
        return switch (scoringCategory) {
            case ONES -> new OnesScorer();
            case TWOS -> new TwosScorer();
            case THREES -> new ThreesScorer();
        };
    }

    public int score(int[] diceRolls) {
        return switch (scoringCategory) {
            case ONES -> scoreOnes(diceRolls);
            case TWOS -> scoreTwos(diceRolls);
            case THREES -> scoreThrees(diceRolls);
        };

    }

    private int scoreThrees(int[] diceRolls) {
        return Arrays.stream(diceRolls).filter(dice -> dice == 3).sum();
    }

    private static int scoreTwos(int[] diceRolls) {
        return Arrays.stream(diceRolls).filter(dice -> dice == 2).sum();
    }

    private int scoreOnes(int[] diceRolls) {
        return Arrays.stream(diceRolls).filter(dice -> dice == 1).sum();
    }
}
