package com.codurance;

import java.util.List;

public class StrikeBonus implements FrameBonus {

    @Override
    public int getExtraScoreFrom(int index, List<Frame> frames) {
        if (frames.size() <= index + 1) {
            return 0;
        }

        Frame frame = frames.get(index + 1);
        int nextIndex = index + 2;
        int bonusScore = frame.firstRoll();

        if (frame.isStrike()) {
            Frame nextFrame = frames.get(nextIndex);
            return bonusScore
                + (null == nextFrame ? 0 : nextFrame.firstRoll());
        }

        return bonusScore + frame.secondRoll();
    }
}
