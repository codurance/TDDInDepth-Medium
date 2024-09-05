public class Game {

    private Player player = Player.PLAYER_X;
    private Board board;

    Game(Board board) {
        this.board = board;
    }

    public Player toPlay() {
        return player;
    }

    public void play(Position positions) {
        if (board.isTaken(positions)) {
            return;
        }
        board.playOn(positions, player);
        player = player.nextPlayer();
    }

    public GameStatus status() {
        return new GameStatus(
            Status.WIN,
            Player.PLAYER_X
        );
    }
}
