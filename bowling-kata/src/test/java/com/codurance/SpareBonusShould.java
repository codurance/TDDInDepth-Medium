package com.codurance;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpareBonusShould {
    @Test
    public void calculate_extra_points_of_a_frame() {

        List<Frame> frames = new ArrayList<>();
        Frame frame0 = new Frame();
        frame0.addRoll(5);
        frame0.addRoll(5);
        Frame frame1 = new Frame();
        frame1.addRoll(5);
        frame1.addRoll(4);
        frames.add(frame0);
        frames.add(frame1);

        FrameBonus spareBonus = new SpareBonus();

        assertEquals(5, spareBonus.getExtraScoreFrom(0, frames));
    }
}
