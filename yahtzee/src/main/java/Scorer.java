import java.util.Arrays;

public class Scorer {
    public int score(ScoringCategory scoringCategory, int[] diceRolls) {
        if (scoringCategory == ScoringCategory.ONES) {
            return scoreOnes(diceRolls);
        } else if (scoringCategory == ScoringCategory.TWOS) {
            return scoreTwos(diceRolls);
        } else if (scoringCategory == ScoringCategory.THREES) {
            return 3;
        }

        return scoreOnes(diceRolls);
    }

    private static int scoreTwos(int[] diceRolls) {
        return Arrays.stream(diceRolls).filter(dice -> dice == 2).sum();
    }

    private int scoreOnes(int[] diceRolls) {
        return Arrays.stream(diceRolls).filter(dice -> dice == 1).sum();
    }
}
