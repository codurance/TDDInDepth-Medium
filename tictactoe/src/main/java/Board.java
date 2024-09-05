import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Position> positions = new ArrayList<>();

    public boolean isTaken(Position position) {
        return positions.contains(position);
    }

    public void playOn(Position position) {
        positions.add(position);
    }
}
