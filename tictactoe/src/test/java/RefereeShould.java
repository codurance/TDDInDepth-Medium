import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RefereeShould {
    public static Stream<Arguments> getVerticalWins() {
        return Stream.of(
            Arguments.of(
                List.of(
                    Position.TOP_LEFT,
                    Position.TOP,
                    Position.CENTER,
                    Position.TOP_RIGHT
                )
            )
        );
    }

    @ParameterizedTest
    @MethodSource("getVerticalWins")
    public void identify_vertical_win(List<Position> positionsTakenBy) {
        Referee referee = new Referee();

        assertTrue(referee.hasWon(positionsTakenBy));
    }
}
