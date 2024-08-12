package com.codurance;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Bonus {
    private final Frames frames;

    public Bonus(Frames frames) {
        this.frames = frames;
    }

    public int getScore() {

        int index = 0;
        AtomicInteger bonusScore = new AtomicInteger();

        List<Frame> frameList = frames.all();

        frameList.forEach((frame -> {
            if (frame.isSpare()) {
                bonusScore.addAndGet(frameList.get(index + 1).firstRoll());
            }
        }));

        return frames.getScore() + bonusScore.get();
    }
}
