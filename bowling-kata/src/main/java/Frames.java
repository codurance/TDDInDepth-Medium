import java.util.List;

public class Frames {
    private final List<Frame> frames;

    public Frames(List<Frame> frames) {
        this.frames = frames;
    }

    public Frame get(int index) {
        return frames.get(index);
    }

    public List<Frame> all() {
        return frames;
    }
}
