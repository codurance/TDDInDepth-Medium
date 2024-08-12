package com.codurance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void know_when_is_a_spare() {
        Frame frame = new Frame();
        frame.addRoll(5);
        frame.addRoll(5);

        assertTrue(frame.isSpare());
        assertFalse(frame.isStrike());
        assertTrue(frame.hasAllRollsThrown());
    }

    @Test
    public void know_when_is_a_strike() {
        Frame frame = new Frame();
        frame.addRoll(10);

        assertFalse(frame.isSpare());
        assertTrue(frame.isStrike());
        assertTrue(frame.hasAllRollsThrown());
    }

    @Test
    public void know_first_roll_value() {
        Frame frame = new Frame();
        frame.addRoll(2);
        frame.addRoll(7);

        assertEquals(2, frame.firstRoll());
    }

    @Test
    public void know_second_roll_value() {
        Frame frame = new Frame();
        frame.addRoll(2);
        frame.addRoll(7);

        assertEquals(7, frame.secondRoll());
    }
}
