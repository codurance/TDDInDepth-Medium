public enum Direction {
    NORTH, SOUTH, EAST, WEST;

    public Direction rotateToLeft() {
        Direction direction = this;
        switch (direction) {
            case NORTH -> direction = Direction.WEST;
            case WEST -> direction = Direction.SOUTH;
            case SOUTH -> direction = Direction.EAST;
            case EAST -> direction = Direction.NORTH;
        }

        return direction;
    }

    public Direction rotateToRight() {
        Direction direction = this;
        switch (direction) {
            case NORTH -> direction = Direction.EAST;
            case EAST -> direction = Direction.SOUTH;
            case SOUTH -> direction = Direction.WEST;
            case WEST -> direction = Direction.NORTH;
        }

        return direction;
    }
}
