public record Position(int axisX, int axisY) {
    public Position moveForward(Direction direction) {
        Position position = this;

        switch (direction) {
            case NORTH -> position = new Position(axisX + 1, axisY);
            case EAST -> position = new Position(axisX, axisY + 1);
            case SOUTH -> position = new Position(axisX - 1, axisY);
            case WEST -> position = new Position(axisX, axisY - 1);
        }

        return position;
    }
}
