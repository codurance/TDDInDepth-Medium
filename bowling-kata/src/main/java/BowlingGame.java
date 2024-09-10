import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    private List<Integer> rolls = new ArrayList<>();

    public int score() {
        return new ScoreCalculator().getScoreOf(rolls);
    }

    public void roll(int pins) {
        rolls.add(pins);
    }
}
