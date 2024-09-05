public class Game {

    private Player player = Player.PLAYER_X;

    public Player toPlay() {
        return player;
    }

    public void play() {
        player = Player.PLAYER_O.equals(player)
            ? Player.PLAYER_X
            : Player.PLAYER_O;
    }
}
