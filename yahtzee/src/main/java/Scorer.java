import java.util.Arrays;

public class Scorer {
    public int score(ScoringCategory scoringCategory, int[] diceRolls) {
        return Arrays.stream(diceRolls).filter(dice -> dice == 1).sum();
    }
}
