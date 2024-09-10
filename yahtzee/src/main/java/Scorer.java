import java.util.Arrays;

public class Scorer {
    public int score(ScoringCategory scoringCategory, int[] diceRolls) {
        if (scoringCategory == ScoringCategory.ONES) {
            return scoreOnes(diceRolls);
        } else if (scoringCategory == ScoringCategory.TWOS) {
            return 2;
        }

        return scoreOnes(diceRolls);
    }

    private int scoreOnes(int[] diceRolls) {
        return Arrays.stream(diceRolls).filter(dice -> dice == 1).sum();
    }
}
