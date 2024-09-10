import java.util.ArrayList;
import java.util.List;

public class ScoreCalculator {
    public int getScoreOf(List<Integer> rolls) {
        Frames frames = getFramesOf(rolls);

        return frames.getScore();
    }

    private Frames getFramesOf(List<Integer> rolls) {
        List<Frame> frames = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < 10; i++) {
            frames.add(new Frame(rolls.get(index), rolls.get(index + 1)));

            index += 2;
        }

        return new Frames(frames);
    }
}
