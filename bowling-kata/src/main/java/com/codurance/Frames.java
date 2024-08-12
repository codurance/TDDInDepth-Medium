package com.codurance;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Frames {
    private final List<Frame> frames = new ArrayList<>();

    public Frames(List<Integer> rolls) {
        int frameIndex = 0;
        frames.add(new Frame());
        for (int roll: rolls) {
            Frame currentFrame = frames.get(frameIndex);

            if (currentFrame.hasAllRollsThrown()) {
                Frame nextFrame = new Frame();
                frames.add(nextFrame);
                currentFrame = nextFrame;
                frameIndex++;
            }

            currentFrame.addRoll(roll);
        }
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
