import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Tile> tiles = new ArrayList<>();

    public boolean contains(Tile tile) {
        return tiles.contains(tile);
    }

    public void add(Tile tile) {
        tiles.add(tile);
    }
}
