import java.util.ArrayList;
import java.util.List;

public class FrameParser {
    public Frames getFramesOf(List<Integer> rolls) {
        List<Frame> frames = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < 10; i++) {
            int firstRoll = rolls.get(index);
            if (10 == firstRoll && i != 9 ) {
                Frame frame = new Frame(firstRoll, 0);
                frames.add(frame);

                index += 1;
                continue;
            }

            if(i == 9 && hasExtraRoll(rolls)) {
                Frame frame = new Frame(firstRoll, rolls.get(index + 1), rolls.get(index + 2));
                frames.add(frame);

                index += 3;
            } else {
                Frame frame = new Frame(firstRoll, rolls.get(index + 1));
                frames.add(frame);

                index += 2;
            }
        }

        return new Frames(frames);
    }

    private static boolean hasExtraRoll(List<Integer> rolls) {
        return rolls.size() == 12 || rolls.size() == 21;
    }
}
