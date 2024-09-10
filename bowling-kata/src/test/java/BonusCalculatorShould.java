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

        assertEquals(3, bonusCalculator.getBonus(frames));
    }

    @Test
    public void calculate_the_bonus_of_a_strike() {
        List<Frame> spare = List.of(
            new Frame(10, 0),
            new Frame(3, 6)
        );
        Frames frames = new Frames(spare);

        BonusCalculator bonusCalculator = new BonusCalculator();

        assertEquals(9, bonusCalculator.getBonus(frames));
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

        assertEquals(20, bonusCalculator.getBonus(frames));
    }
}
