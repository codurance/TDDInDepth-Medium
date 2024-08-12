package com.codurance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameShould {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @ParameterizedTest
    @CsvSource({
        "5, 5",
        "0, 0",
        "10, 10",
    })
    public void calculate_the_score_of_a_roll(int pins, int expectedScore) {
        game.roll(pins);

        assertEquals(expectedScore, game.score());
    }

    @Test
    public void calculate_the_score_of_two_rolls() {
        game.roll(3);
        game.roll(6);

        assertEquals(9, game.score());
    }

    @Test
    public void calculate_the_score_of_a_spare() {
        game.roll(5);
        game.roll(5);
        game.roll(5);

        assertEquals(20, game.score());
    }

    @Test
    public void calculate_the_score_of_multiple_spare() {
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);

        assertEquals(35, game.score());
    }

    @Test
    public void calculate_the_score_of_a_strike() {
        game.roll(10);
        game.roll(5);
        game.roll(4);

        assertEquals(28, game.score());
    }

    @Test
    public void calculate_the_score_of_two_consecutive_strikes() {
        game.roll(10);
        game.roll(10);
        game.roll(5);
        game.roll(4);

        assertEquals(53, game.score());
    }

    @Test
    public void calculate_the_score_of_multiple_consecutive_rolls() {
        game.roll(10);
        game.roll(10);
        game.roll(5);
        game.roll(5);
        game.roll(4);
        game.roll(4);
        game.roll(10);
        game.roll(5);
        game.roll(4);

        // 25 + 20 + 14 + 8 + 19 + 5 + 4

        assertEquals(95, game.score());
    }
}
