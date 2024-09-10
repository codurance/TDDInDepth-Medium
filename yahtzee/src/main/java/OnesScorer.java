import java.util.Arrays;

public class OnesScorer extends Scorer {

    @Override
    public int score(int[] diceRolls) {
        return Arrays.stream(diceRolls).filter(dice -> dice == 1).sum();
    }
}
