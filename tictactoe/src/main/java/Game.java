import java.util.ArrayList;
import java.util.List;

public class Game {

    private Player player = Player.PLAYER_X;
    private List<Tile> tiles = new ArrayList<>();

    public Player toPlay() {
        return player;
    }

    public void play(Tile tile) {
        if (tiles.contains(tile)) {
            return;
        }
        tiles.add(tile);
        player = player.nextPlayer();
    }

}
