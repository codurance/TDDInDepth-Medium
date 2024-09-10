import java.util.ArrayList;
import java.util.List;

public class FrameParser {

    private static final int TOTAL_FRAMES = 10;
    private static final int MAX_PINS_PER_ROLL = 10;
    private static final int LAST_FRAME_INDEX = 9;
    private static final int MAX_ROLLS = 21;
    private static final int PERFECT_GAME_ROLLS = 12;

    public Frames getFramesOf(List<Integer> rolls) {
        List<Frame> frames = new ArrayList<>();
        int index = 0;

        for (int i = 0; i < TOTAL_FRAMES; i++) {
            int firstRoll = rolls.get(index);

            if (isStrike(rolls, index, i)) {
                frames.add(new Frame(firstRoll, 0));
                index++;
                continue;
            }

            if (isTenthFrameWithExtraRoll(rolls, i)) {
                frames.add(new Frame(firstRoll, rolls.get(index + 1), rolls.get(index + 2)));
                index += 3;
                continue;
            }

            frames.add(new Frame(firstRoll, rolls.get(index + 1)));
            index += 2;
        }

        return new Frames(frames);
    }

    private boolean isStrike(List<Integer> rolls, int index, int frameIndex) {
        return rolls.get(index) == MAX_PINS_PER_ROLL && frameIndex != LAST_FRAME_INDEX;
    }

    private boolean isTenthFrameWithExtraRoll(List<Integer> rolls, int frameIndex) {
        return frameIndex == LAST_FRAME_INDEX && hasExtraRoll(rolls);
    }

    private boolean hasExtraRoll(List<Integer> rolls) {
        return rolls.size() == PERFECT_GAME_ROLLS || rolls.size() == MAX_ROLLS;
    }
}
