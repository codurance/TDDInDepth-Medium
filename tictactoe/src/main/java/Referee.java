import java.util.List;

public class Referee {
    public boolean hasWon(List<Position> positions) {
        return positions.size() == 3;
    }
}
