import java.util.Arrays;

public class TwosScorer extends Scorer {
    protected TwosScorer() {
        super(ScoringCategory.TWOS);
    }

    @Override
    public int score(int[] diceRolls) {
        return Arrays.stream(diceRolls).filter(dice -> dice == 2).sum();
    }
}
