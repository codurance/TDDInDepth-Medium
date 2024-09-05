import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameShould {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game(new Board());
    }

    @Test
    public void wait_for_player_X_to_play() {
        assertEquals(Player.PLAYER_X, game.toPlay());
    }

    @Test
    public void wait_for_player_O_to_play_after_player_X() {
        game.play(Position.TOP_LEFT);

        assertEquals(Player.PLAYER_O, game.toPlay());
    }

    @Test
    public void wait_for_player_X_to_play_after_player_O() {
        game.play(Position.TOP_LEFT);
        game.play(Position.TOP);

        assertEquals(Player.PLAYER_X, game.toPlay());
    }

    @Test
    public void not_allow_players_to_play_on_already_taken_positions() {
        game.play(Position.TOP_LEFT);
        game.play(Position.TOP_LEFT);

        assertEquals(Player.PLAYER_O, game.toPlay());
    }

    @Test
    public void return_game_status() {
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
}
