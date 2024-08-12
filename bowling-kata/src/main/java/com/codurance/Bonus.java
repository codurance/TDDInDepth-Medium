package com.codurance;

import java.util.List;

public class Bonus {
    private final Frames frames;

    public Bonus(Frames frames) {
        this.frames = frames;
    }

    public int getScore() {

        int bonusScore = 0;

        List<Frame> frameList = frames.all();

        for (int index = 0; index < frameList.size(); index++) {
            Frame frame = frameList.get(index);
            if (frame.isSpare()) {
                bonusScore += frameList.get(index + 1).firstRoll();
            }
        }

        return frames.getScore() + bonusScore;
    }
}
