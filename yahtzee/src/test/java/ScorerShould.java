import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScorerShould {
    @ParameterizedTest
    @MethodSource("onesProvider")
    public void score_with_ones_scoring_category(int expectedScore, int[] dice) {
        Scorer scorer = Scorer.forCategory(ScoringCategory.ONES);

        int score = scorer.score( dice);

        assertEquals(expectedScore, score);
    }

    @ParameterizedTest
    @MethodSource("twosProvider")
    public void score_with_twos_scoring_category(int expectedScore, int[] dice) {
        Scorer scorer = Scorer.forCategory(ScoringCategory.TWOS);

        int score = scorer.score(dice);

        assertEquals(expectedScore, score);
    }

    @ParameterizedTest
    @MethodSource("threesProvider")
    public void score_with_threes_scoring_category(int expectedScore, int[] dice) {
        Scorer scorer = Scorer.forCategory(ScoringCategory.THREES);

        int score = scorer.score(dice);

        assertEquals(expectedScore, score);
    }

    public static Stream<Arguments> onesProvider() {
        return Stream.of(
            Arguments.of(
                1,
                new int[]{1, 2, 3, 4, 5}
            ),
            Arguments.of(
                2,
                new int[]{1, 1, 3, 4, 5}
            )
        );
    }

    public static Stream<Arguments> twosProvider() {
        return Stream.of(
            Arguments.of(
                2,
                new int[]{1, 2, 3, 4, 5}
            ),
            Arguments.of(
                4,
                new int[]{2, 2, 3, 4, 5}
            )
        );
    }

    public static Stream<Arguments> threesProvider() {
        return Stream.of(
            Arguments.of(
                3,
                new int[]{1, 2, 3, 4, 5}
            ),
            Arguments.of(
                9,
                new int[]{3, 3, 3, 4, 5}
            )
        );
    }
}

