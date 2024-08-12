package com.codurance;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FramesShould {
    @Test
    public void have_multiple_frames() {
        List<Integer> rolls = new ArrayList<>();
        rolls.add(4);
        rolls.add(5);
        rolls.add(3);

        Frames frames = new Frames(rolls);

        assertEquals(2, frames.all().size());
    }
}
