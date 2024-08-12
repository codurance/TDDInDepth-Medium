package com.codurance;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Frames {
    private final List<Frame> frames = new ArrayList<>();

    public Frames(List<Integer> rolls) {

        rolls.forEach((roll) -> {
            if (frames.isEmpty()) {
                frames.add(new Frame());
            }

            Frame currentFrame = frames.getLast();
            currentFrame.addRoll(roll);
        });
    }

    public int getScore() {
        Optional<Integer> score = frames.stream().map(Frame::pins).reduce(Integer::sum);

        return score.orElse(0);
    }
}
