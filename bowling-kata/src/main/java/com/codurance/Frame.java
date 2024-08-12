package com.codurance;


import java.util.ArrayList;
import java.util.List;

public class Frame {
    private List<Integer> rolls = new ArrayList<>();

    public void addRoll(Integer roll) {
        rolls.add(roll);
    }

    public int pins() {
        return rolls.stream().reduce(Integer::sum).orElse(0);
    }

    public boolean hasAllRollsThrown() {
        return pins() == 10 || rolls.size() == 2;
    }

    public boolean isSpare() {
        return rolls.size() == 2 && pins() == 10;
    }

    public int firstRoll() {
        return rolls.getFirst();
    }

    public int secondRoll() {
        return rolls.size() > 1 ? rolls.get(1) : 0;
    }

    public boolean isStrike() {
        return rolls.size() == 1 && pins() == 10;
    }
}
