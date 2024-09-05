import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private Map<Position, Player> playerPositions = new HashMap<>();

    public boolean isTaken(Position position) {
        return playerPositions.containsKey(position);
    }

    public void playOn(Position position, Player player) {
        playerPositions.put(position, player);
    }

    public List<Position> positionsTakenBy(Player player) {
        return playerPositions.entrySet().stream()
            .filter(positionPlayerEntry -> player.equals(positionPlayerEntry.getValue()))
            .map(Map.Entry::getKey)
            .toList();
    }

    public boolean isFull() {
        return playerPositions.size() == 9;
    }
}
