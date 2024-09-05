import java.util.ArrayList;
import java.util.List;

public class Game {

    private Player player = Player.PLAYER_X;
    private Board board;

    Game(Board board) {
        this.board = board;
    }

    public Player toPlay() {
        return player;
    }

    public void play(Tile tile) {
        if (board.contains(tile)) {
            return;
        }
        board.add(tile);
        player = player.nextPlayer();
    }

}
