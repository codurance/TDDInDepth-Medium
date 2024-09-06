import java.util.HashSet;
import java.util.List;

public class Referee {

    private List<List<Position>> rules = List.of(
        List.of(
            Position.TOP_LEFT,
            Position.TOP,
            Position.TOP_RIGHT
        ),
        List.of(
            Position.CENTER_LEFT,
            Position.CENTER,
            Position.CENTER_RIGHT
        ),
        List.of(
            Position.BOTTOM_LEFT,
            Position.BOTTOM,
            Position.BOTTOM_RIGHT
        ),

        List.of(
            Position.TOP_LEFT,
            Position.CENTER_LEFT,
            Position.BOTTOM_LEFT
        ),
        List.of(
            Position.TOP,
            Position.CENTER,
            Position.BOTTOM
        ),
        List.of(
            Position.TOP_RIGHT,
            Position.CENTER_RIGHT,
            Position.BOTTOM_RIGHT
        ),
        List.of(
            Position.TOP_LEFT,
            Position.CENTER,
            Position.BOTTOM_RIGHT
        ),
        List.of(
            Position.TOP_RIGHT,
            Position.CENTER,
            Position.BOTTOM_LEFT
        )
    );;

    public boolean hasWon(List<Position> positions) {

        return rules.stream()
            .anyMatch(
                rule -> new HashSet<>(positions).containsAll(rule)
            );
    }
}
