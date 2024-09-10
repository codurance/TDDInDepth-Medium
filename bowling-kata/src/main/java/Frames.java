import java.util.List;

public class Frames {
    private final List<Frame> frames;

    public Frames(List<Frame> frames) {

        this.frames = frames;
    }

    public int getScore() {
        return frames.stream().map(Frame::sumRolls).reduce(Integer::sum).orElse(0);
    }

    public Frame get(int index) {
        return frames.get(index);
    }
}
