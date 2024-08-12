package com.codurance;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Integer> rolls = new ArrayList<>();

    public void roll(int pins) {
        this.rolls.add(pins);
    }

    public int score() {
        Frames frames = new Frames(rolls);

        Bonus bonus = new Bonus(frames);

        return bonus.getExtraScore() + frames.getScore();
    }
}
