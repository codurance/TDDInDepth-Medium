package com.codurance;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Game {

    private List<Integer> rolls = new ArrayList<>();

    public void roll(int pins) {
        this.rolls.add(pins);
    }

    public int score() {
        Frames frames = new Frames(rolls);

        return frames.getScore();
    }
}
