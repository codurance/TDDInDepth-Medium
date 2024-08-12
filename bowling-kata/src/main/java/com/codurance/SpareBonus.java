package com.codurance;

import java.util.List;

public class SpareBonus implements FrameBonus {

    @Override
    public int getExtraScoreFrom(int index, List<Frame> frames) {
        return frames.get(index + 1).firstRoll();
    }
}
