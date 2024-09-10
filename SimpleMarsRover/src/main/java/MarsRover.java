public class MarsRover {
    private Direction direction;
    private Position position;
    private final Planet planet;

    public MarsRover(Direction direction, Position position, Planet planet) {
        this.direction = direction;
        this.position = position;
        this.planet = planet;
    }

    public void execute(String commands) {
        for (char command : commands.toCharArray()) {
            switch (command) {
                case 'L' -> direction = direction.rotateToLeft();
                case 'R' -> direction = direction.rotateToRight();
                case 'F' -> position = position.moveForward(direction, planet);
                case 'B' -> position = position.moveBackward(direction, planet);
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
