public class Game {

    private Player player = Player.PLAYER_X;

    public Player toPlay() {
        return player;
    }

    public void play() {
        player = player.nextPlayer();
    }

}
