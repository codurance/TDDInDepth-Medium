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

    public void play(Position position) {
        if (isInvalidPlay(position)) {
            return;
        }

        board.playOn(position, player);
        if (hasWon()) {
            status = Status.WIN;
            return;
        }

        if (isADraw()) {
            status = Status.DRAW;
            player = null;
            return;
        }

        player = player.nextPlayer();
    }

    private boolean isADraw() {
        return board.isFull();
    }

    private boolean hasWon() {
        return referee.hasWon(board.positionsTakenBy(player));
    }

    private boolean isInvalidPlay(Position positions) {
        return board.isTaken(positions);
    }

    public GameStatus status() {
        return new GameStatus(
            status,
            player
        );
    }
}
