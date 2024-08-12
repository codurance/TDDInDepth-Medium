package com.codurance;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Frames {
    private final List<Frame> frames = new ArrayList<>();

    public Frames(List<Integer> rolls) {

        rolls.forEach((roll) -> {
            Optional<Frame> currentFrame = frames.stream().findFirst();
            if (currentFrame.isEmpty() || currentFrame.get().hasAllRollsThrown()) {
                currentFrame = Optional.of(newFrame());
            }
            currentFrame.get().addRoll(roll);
        });
    }

    private Frame newFrame() {
        Frame frame = new Frame();
        frames.add(frame);

        return frame;
    }

    public int getScore() {
        Optional<Integer> score = frames.stream().map(Frame::pins).reduce(Integer::sum);

        return score.orElse(0);
    }

    public List<Frame> all() {
        return frames;
    }
}
