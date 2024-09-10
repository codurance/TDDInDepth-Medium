import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    private final ScoreCalculator scoreCalculator;
    private List<Integer> rolls = new ArrayList<>();

    public BowlingGame(ScoreCalculator scoreCalculator) {
        this.scoreCalculator = scoreCalculator;
    }

    public int score() {
        return scoreCalculator.getScoreOf(rolls);
    }

    public void roll(int pins) {
        rolls.add(pins);
    }
}
