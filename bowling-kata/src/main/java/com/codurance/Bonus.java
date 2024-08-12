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
            int nextIndex = index + 1;
            if (frame.isSpare()) {
                bonusScore += frameList.get(nextIndex).firstRoll();
            }

            if (frame.isStrike()) {
                if (frameList.size() <= nextIndex) {
                    continue;
                }

                Frame nextFrame = frameList.get(nextIndex);
                int afterNextIndex = nextIndex + 1;
                bonusScore += nextFrame.firstRoll();

                if (nextFrame.isStrike()) {
                    Frame afterNextFrame = frameList.get(afterNextIndex);
                    bonusScore += null == afterNextFrame ? 0 : afterNextFrame.firstRoll();
                } else {
                    bonusScore += nextFrame.secondRoll();
                }
            }
        }

        return frames.getScore() + bonusScore;
    }
}
