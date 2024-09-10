import java.util.List;

public class ScoreCalculator {
    private final BonusCalculator bonusCalculator;
    private final FrameParser frameParser;

    public ScoreCalculator(FrameParser frameParser, BonusCalculator bonusCalculator) {
        this.frameParser = frameParser;
        this.bonusCalculator = bonusCalculator;
    }

    public int getScoreOf(List<Integer> rolls) {
        Frames frames = frameParser.getFramesOf(rolls);

        return frames.getScore() + bonusCalculator.getBonus(frames);
    }
}
