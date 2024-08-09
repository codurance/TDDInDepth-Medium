package com.codurance;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameShould {
    @ParameterizedTest
    @CsvSource({
        "5, 5",
        "0, 0",
        "10, 10",
    })
    public void calculate_the_score_of_a_roll(int pins, int expectedScore) {
        Game game = new Game();

        game.roll(pins);

        assertEquals(expectedScore, game.score());
    }

    @Test
    public void calculate_the_score_of_two_rolls() {
        Game game = new Game();

        game.roll(3);
        game.roll(7);

        assertEquals(10, game.score());
    }
}
