package com.codurance;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StrikeBonusShould {
    @Test
    public void calculate_extra_points_of_a_frame_when_next_is_not_a_strike() {
        List<Frame> frames = new ArrayList<>();
        Frame frame0 = new Frame();
        frame0.addRoll(10);
        Frame frame1 = new Frame();
        frame1.addRoll(5);
        frame1.addRoll(5);
        frames.add(frame0);
        frames.add(frame1);

        FrameBonus strikeBonus = new StrikeBonus();

        assertEquals(10, strikeBonus.getExtraScoreFrom(0, frames));

    }

    @Test
    public void calculate_extra_points_of_a_frame_when_next_is_a_strike() {
        List<Frame> frames = new ArrayList<>();
        Frame frame0 = new Frame();
        frame0.addRoll(10);
        Frame frame1 = new Frame();
        frame1.addRoll(10);
        Frame frame2 = new Frame();
        frame2.addRoll(5);
        frames.add(frame0);
        frames.add(frame1);
        frames.add(frame2);

        FrameBonus strikeBonus = new StrikeBonus();

        assertEquals(15, strikeBonus.getExtraScoreFrom(0, frames));

    }
}
