public class MarsRover {
    private Direction direction;
    private Position position;

    public MarsRover(Direction direction, Position position) {
        this.direction = direction;
        this.position = position;
    }

    public void execute(String commands) {
        for (char command : commands.toCharArray()) {
            switch (command) {
                case 'L' -> direction = direction.rotateToLeft();
                case 'R' -> direction = direction.rotateToRight();
                case 'F' -> position = position.moveForward(direction);
            }
        }
    }

    public Direction direction() {
        return direction;
    }

    public Position position() {
        return position;
    }
}
