import java.util.Arrays;

public class OnesScorer extends Scorer {
    public OnesScorer() {
        super(ScoringCategory.ONES);
    }

    @Override
    public int score(int[] diceRolls) {
        return Arrays.stream(diceRolls).filter(dice -> dice == 1).sum();
    }
}
