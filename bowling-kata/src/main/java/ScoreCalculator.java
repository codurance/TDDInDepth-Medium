import java.util.List;

public class ScoreCalculator {
    public int getScoreOf(List<Integer> rolls) {
        return rolls.stream()
            .reduce(Integer::sum)
            .orElse(0);
    }
}
