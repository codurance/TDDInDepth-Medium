import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScorerShould {
    @Test
    public void score_with_ones_scoring_category() {
        Scorer scorer = new Scorer();

        int expectedScore = 1;
        assertEquals(expectedScore, scorer.score(ScoringCategory.ONES, new int[]{1, 2, 3, 4, 5}));
    }
}
