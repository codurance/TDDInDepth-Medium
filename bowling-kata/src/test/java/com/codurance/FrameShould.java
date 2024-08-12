package com.codurance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FrameShould {
    @Test
    public void know_when_all_rolls_are_thrown_on_strike() {
        Frame frame = new Frame();
        frame.addRoll(10);

        assertTrue(frame.hasAllRollsThrown());
    }

    @Test
    public void know_when_all_rolls_are_thrown_on_spare() {
        Frame frame = new Frame();
        frame.addRoll(4);
        frame.addRoll(6);

        assertTrue(frame.hasAllRollsThrown());
    }

    @Test
    public void know_when_all_rolls_are_thrown() {
        Frame frame = new Frame();
        frame.addRoll(4);
        frame.addRoll(5);

        assertTrue(frame.hasAllRollsThrown());
    }

}
