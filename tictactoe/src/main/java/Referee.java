import java.util.HashSet;
import java.util.List;

public class Referee {

    public boolean hasWon(List<Position> positions) {
        var rules = List.of(
            List.of(
                Position.TOP_LEFT,
                Position.TOP,
                Position.TOP_RIGHT
            )
        );

        return rules.stream()
            .anyMatch(
                rule -> new HashSet<>(positions).containsAll(rule)
            );
    }
}
