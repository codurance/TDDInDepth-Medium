public class MarsRover {
    private Direction direction;

    public MarsRover(Direction direction) {
        this.direction = direction;
    }

    public Direction direction() {
        return direction;
    }

    public void execute(String commands) {
        for (char command : commands.toCharArray()) {
            if (command == 'L') {
                switch (direction) {
                    case NORTH -> direction = Direction.WEST;
                    case WEST -> direction = Direction.SOUTH;
                    case SOUTH -> direction = Direction.EAST;
                    case EAST -> direction = Direction.NORTH;
                }
            }

            if (command == 'R') {
                switch (direction) {
                    case NORTH -> direction = Direction.EAST;
                    case EAST -> direction = Direction.SOUTH;
                    case SOUTH -> direction = Direction.WEST;
                    case WEST -> direction = Direction.NORTH;
                }
            }
        }
    }
}
