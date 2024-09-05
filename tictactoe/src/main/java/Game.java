public class Game {

    private Player player = Player.PLAYER_X;
    private Board board;
    private Status status;
    private Referee referee;

    Game(Board board, Referee referee) {
        this.board = board;
        this.referee = referee;
        this.status = Status.PLAYING;
    }

    public Player toPlay() {
        return player;
    }

    public void play(Position positions) {
        if (board.isTaken(positions)) {
            return;
        }
        board.playOn(positions, player);
        if (referee.hasWon(board.positionsTakenBy(player))) {
            status = Status.WIN;
            return;
        }

        player = player.nextPlayer();
    }

    public GameStatus status() {
        return new GameStatus(
            status,
            player
        );
    }
}
