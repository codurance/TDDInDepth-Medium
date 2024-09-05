import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameShould {
    @Test
    public void wait_for_player_X_to_play() {

        Game game = new Game();

        assertEquals(Player.PLAYER_X, game.toPlay());
    }
}
