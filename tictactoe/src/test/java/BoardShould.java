import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardShould {

    @Test
    public void know_when_position_is_taken() {
        Board board = new Board();

        board.playOn(Position.TOP_LEFT, Player.PLAYER_O);

        assertTrue(board.isTaken(Position.TOP_LEFT));
    }

    @Test
    public void put_player_in_empty_position() {
        Board board = new Board();

        board.playOn(Position.TOP_LEFT, Player.PLAYER_O);

        List<Position> positions = board.positionsTakenBy(Player.PLAYER_O);

        assertEquals(List.of(Position.TOP_LEFT), positions);
    }

    @Test
    public void positions_retrieved_by_player() {
        Board board = new Board();

        board.playOn(Position.TOP_LEFT, Player.PLAYER_O);
        board.playOn(Position.TOP, Player.PLAYER_X);

        List<Position> positions = board.positionsTakenBy(Player.PLAYER_X);

        assertEquals(List.of(Position.TOP), positions);
    }

    @Test
    public void be_full_when_all_positions_played() {
        Board board = new Board();

        board.playOn(Position.TOP_LEFT, Player.PLAYER_O);
        board.playOn(Position.TOP, Player.PLAYER_X);
        board.playOn(Position.TOP_RIGHT, Player.PLAYER_O);
        board.playOn(Position.CENTER_LEFT, Player.PLAYER_X);
        board.playOn(Position.CENTER, Player.PLAYER_O);
        board.playOn(Position.CENTER_RIGHT, Player.PLAYER_X);
        board.playOn(Position.BOTTOM_LEFT, Player.PLAYER_O);
        board.playOn(Position.BOTTOM, Player.PLAYER_X);
        board.playOn(Position.BOTTOM_RIGHT, Player.PLAYER_O);

        assertTrue(board.isFull());
    }
}
