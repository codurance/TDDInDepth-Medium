import java.util.ArrayList;
import java.util.List;

public class ScoreCalculator {
    public int getScoreOf(List<Integer> rolls) {
        Frames frames = getFramesOf(rolls);

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

    private Frames getFramesOf(List<Integer> rolls) {
        List<Frame> frames = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < 10; i++) {
            Frame frame = new Frame(rolls.get(index), rolls.get(index + 1));
            frames.add(frame);

            index += 2;
        }

        return new Frames(frames);
    }
}
