package com.codurance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameShould {
    @Test
    public void calculate_the_score_of_a_roll() {
        Game game = new Game();

        game.roll(5);

        assertEquals(5, game.score());
    }
}
