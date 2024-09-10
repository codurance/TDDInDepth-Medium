import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BonusCalculatorShould {
    @Test
    public void calculate_the_bonus_of_a_spare() {
        List<Frame> spare = List.of(
            new Frame(5, 5),
            new Frame(3, 6)
        );
        Frames frames = new Frames(spare);

        BonusCalculator bonusCalculator = new BonusCalculator();

        assertEquals(List.of(
            new BonusFrame(5, 5, 0, 3),
            new BonusFrame(3, 6, 0, 0)
        ), bonusCalculator.getBonusFrames(frames));
    }

    @Test
    public void calculate_the_bonus_of_a_strike() {
        List<Frame> spare = List.of(
            new Frame(10, 0),
            new Frame(3, 6)
        );
        Frames frames = new Frames(spare);

        BonusCalculator bonusCalculator = new BonusCalculator();

        assertEquals(List.of(
            new BonusFrame(10, 0, 0, 9),
            new BonusFrame(3, 6, 0, 0)
        ), bonusCalculator.getBonusFrames(frames));
    }

    @Test
    public void calculate_the_bonus_of_multiple_strikes() {
        List<Frame> spare = List.of(
            new Frame(10, 0),
            new Frame(10, 0),
            new Frame(4, 2)
        );
        Frames frames = new Frames(spare);

        BonusCalculator bonusCalculator = new BonusCalculator();

        assertEquals(List.of(
            new BonusFrame(10, 0, 0, 14),
            new BonusFrame(10, 0, 0, 6),
            new BonusFrame(4, 2, 0, 0)
        ), bonusCalculator.getBonusFrames(frames));
    }

    @Test
    public void calculate_the_bonus_of_last_frame_with_multiple_strikes() {
        List<Frame> spare = List.of(
            new Frame(10, 0),
            new Frame(10, 0),
            new Frame(10, 0),
            new Frame(10, 0),
            new Frame(10, 0),

            new Frame(10, 0),
            new Frame(10, 0),
            new Frame(10, 0),
            new Frame(10, 0),
            new Frame(10, 10, 10)
        );
        Frames frames = new Frames(spare);

        BonusCalculator bonusCalculator = new BonusCalculator();

        assertEquals(List.of(
            new BonusFrame(10, 0, 0, 20),
            new BonusFrame(10, 0, 0, 20),
            new BonusFrame(10, 0, 0, 20),
            new BonusFrame(10, 0, 0, 20),
            new BonusFrame(10, 0, 0, 20),

            new BonusFrame(10, 0, 0, 20),
            new BonusFrame(10, 0, 0, 20),
            new BonusFrame(10, 0, 0, 20),
            new BonusFrame(10, 0, 0, 20),
            new BonusFrame(10, 10, 10, 0)
        ), bonusCalculator.getBonusFrames(frames));
    }
}
