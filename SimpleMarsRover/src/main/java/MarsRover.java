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
            switch (command) {
                case 'L' -> direction = direction.rotateToLeft();
                case 'R' -> direction = direction.rotateToRight();
            }
        }
    }
}
