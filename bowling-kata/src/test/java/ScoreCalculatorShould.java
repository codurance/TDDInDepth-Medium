import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreCalculatorShould {
    @Test
    public void calculate_a_spare_frame_points_including_the_bonus() {
        ScoreCalculator scoreCalculator = new ScoreCalculator();

        List<Integer> rolls = new ArrayList<>();
        rolls.add(4);
        rolls.add(6);
        rolls.add(2);
        rolls.addAll(Collections.nCopies(17, 0));

        assertEquals(14, scoreCalculator.getScoreOf(rolls));
    }
}
