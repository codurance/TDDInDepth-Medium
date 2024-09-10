import java.util.List;

public class ScoreCalculator {
    private final FrameParser frameParser;

    public ScoreCalculator(FrameParser frameParser) {

        this.frameParser = frameParser;
    }

    public int getScoreOf(List<Integer> rolls) {
        Frames frames = frameParser.getFramesOf(rolls);

        return frames.getScore() + getBonus(frames);
    }

    private int getBonus(Frames frames) {
        int score = 0;
        for (int i = 0; i < 10; i++) {
            Frame frame = frames.get(i);
            if (frame.isSpare()) {
                score += frames.get(i + 1).firstRoll();
            }
        }

        return score;
    }

}
