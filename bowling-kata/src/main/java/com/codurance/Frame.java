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
}
