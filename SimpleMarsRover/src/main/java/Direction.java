public enum Direction {
    NORTH, SOUTH, EAST, WEST;

    public Direction rotateToLeft() {
        return switch (this) {
            case NORTH -> Direction.WEST;
            case WEST -> Direction.SOUTH;
            case SOUTH -> Direction.EAST;
            case EAST -> Direction.NORTH;
        };
    }

    public Direction rotateToRight() {
        return switch (this) {
            case NORTH -> Direction.EAST;
            case EAST -> Direction.SOUTH;
            case SOUTH -> Direction.WEST;
            case WEST -> Direction.NORTH;
        };
    }
}
