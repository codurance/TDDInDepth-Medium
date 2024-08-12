package com.codurance;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BonusShould {
    @Test
    public void calculate_the_extra_score_of_multiple_consecutive_rolls() {
        List<Integer> rolls = new ArrayList<>();
        rolls.add(10);

        rolls.add(10);

        rolls.add(5);
        rolls.add(5);

        rolls.add(5);
        rolls.add(4);

        Frames frames = new Frames(rolls);

        Bonus bonus = new Bonus(frames);

        assertEquals(30, bonus.getExtraScore());
    }

}
