import java.util.Arrays;

public class Scorer {
    public int score(ScoringCategory scoringCategory, int[] diceRolls) {
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
