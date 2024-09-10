import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class BowlingGameShould {

    /**
     * Bowling Rules
     *
     * The game consists of 10 frames. In each frame the player has two rolls to knock down 10 pins. The score for the frame is the total number of pins knocked down, plus bonuses for strikes and spares.
     *
     * A spare is when the player knocks down all 10 pins in two rolls. The bonus for that frame is the number of pins knocked down by the next roll.
     *
     * A strike is when the player knocks down all 10 pins on his first roll. The frame is then completed with a single roll. The bonus for that frame is the value of the next two rolls.
     *
     * In the tenth frame a player who rolls a spare or strike is allowed to roll the extra balls to complete the frame. However no more than three balls can be rolled in tenth frame.
     *
     * Requirements
     * Write a class Game that has two methods
     *
     * void roll(int) is called each time the player rolls a ball. The argument is the number of pins knocked down.
     * int score() returns the total score for that game.
     */

    private BowlingGame game;

    @BeforeEach
    void setUp() {
        game = new BowlingGame(new ScoreCalculator(new FrameParser()));
    }

    @Test
    public void get_score_of_a_gutter_game() {

        roll(20, 0);

        assertSame(0, game.score());
    }

    @Test
    public void get_score_of_an_all_ones_game() {

        roll(20, 1);

        assertSame(20, game.score());
    }

    @Test
    public void get_score_of_a_spare() {

        game.roll(5);
        game.roll(5);
        game.roll(4);

        roll(17, 0);

        assertSame(18, game.score());
    }

    private void roll(int times, int pins) {
        for (int i = 0; i < times; i++) {
            game.roll(pins);
        }
    }
}
