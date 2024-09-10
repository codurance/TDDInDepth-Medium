import java.util.ArrayList;
import java.util.List;

public class FrameParser {
    public Frames getFramesOf(List<Integer> rolls) {
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
