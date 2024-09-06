import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameShould {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game(new Board(), new Referee());
    }

    @Test
    public void wait_for_player_X_to_play() {
        assertEquals(new GameStatus(
            Status.PLAYING,
            Player.PLAYER_X
        ), game.status());
    }

    @Test
    public void wait_for_player_O_to_play_after_player_X() {
        game.play(Position.TOP_LEFT);

        assertEquals(new GameStatus(
            Status.PLAYING,
            Player.PLAYER_O
        ), game.status());
    }

    @Test
    public void wait_for_player_X_to_play_after_player_O() {
        game.play(Position.TOP_LEFT);
        game.play(Position.TOP);

        assertEquals(new GameStatus(
            Status.PLAYING,
            Player.PLAYER_X
        ), game.status());
    }

    @Test
    public void not_allow_players_to_play_on_already_taken_positions() {
        game.play(Position.TOP_LEFT);
        game.play(Position.TOP_LEFT);

        assertEquals(new GameStatus(
            Status.PLAYING,
            Player.PLAYER_O
        ), game.status());
    }

    @Test
    public void declare_player_X_as_winner() {
        game.play(Position.TOP_LEFT);
        game.play(Position.CENTER);
        game.play(Position.TOP);
        game.play(Position.CENTER_RIGHT);
        game.play(Position.TOP_RIGHT);

        assertEquals(new GameStatus(
            Status.WIN,
            Player.PLAYER_X
        ), game.status());
    }

    @Test
    public void declare_player_O_as_winner() {
        game.play(Position.BOTTOM_LEFT);
        game.play(Position.TOP_LEFT);
        game.play(Position.CENTER);
        game.play(Position.TOP);
        game.play(Position.CENTER_RIGHT);
        game.play(Position.TOP_RIGHT);

        assertEquals(new GameStatus(
            Status.WIN,
            Player.PLAYER_O
        ), game.status());
    }

    @Test
    public void declare_a_draw_when_is_no_winner() {
        // X O X
        // X O O
        // O X X
        game.play(Position.TOP_LEFT);
        game.play(Position.TOP);
        game.play(Position.TOP_RIGHT);
        game.play(Position.CENTER);
        game.play(Position.CENTER_LEFT);
        game.play(Position.CENTER_RIGHT);
        game.play(Position.BOTTOM);
        game.play(Position.BOTTOM_LEFT);
        game.play(Position.BOTTOM_RIGHT);

        assertEquals(new GameStatus(
            Status.DRAW,
            null
        ), game.status());
    }
}
