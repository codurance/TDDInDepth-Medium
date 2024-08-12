package com.codurance;

import java.util.List;

public class Bonus {
    private final Frames frames;

    public Bonus(Frames frames) {
        this.frames = frames;
    }

    public int getExtraScore() {

        int extraScore = 0;

        List<Frame> frameList = frames.all();

        for (int index = 0; index < frameList.size(); index++) {
            Frame frame = frameList.get(index);

            if (frame.isSpare()) {
                extraScore += new SpareBonus().getExtraScoreFrom(index, frameList);
            }

            if (frame.isStrike()) {
                extraScore += new StrikeBonus().getExtraScoreFrom(index, frameList);
            }
        }

        return extraScore;
    }
}
