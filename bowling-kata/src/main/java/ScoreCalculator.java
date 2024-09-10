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

        return bonusCalculator.getBonusFrames(frames)
            .stream()
            .map(BonusFrame::score)
            .reduce(Integer::sum)
            .orElse(0);
    }
}
