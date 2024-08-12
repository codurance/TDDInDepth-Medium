package com.codurance;

import java.util.List;
import java.util.Optional;

public class Frames {
    private final List<Integer> rolls;

    public Frames(List<Integer> rolls) {

        this.rolls = rolls;
    }

    public int getScore() {
        Optional<Integer> score = rolls.stream().reduce(Integer::sum);

        return score.orElse(0);
    }
}
