public enum Player {
    PLAYER_O, PLAYER_X;

    Player nextPlayer() {
        return PLAYER_O.equals(this)
            ? PLAYER_X
            : PLAYER_O;
    }
}
