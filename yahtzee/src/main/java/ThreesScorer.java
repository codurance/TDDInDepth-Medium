import java.util.Arrays;

public class ThreesScorer extends Scorer {

    @Override
    public int score(int[] diceRolls) {
        return Arrays.stream(diceRolls).filter(dice -> dice == 3).sum();
    }
}
