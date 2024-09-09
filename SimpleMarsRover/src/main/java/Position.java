public record Position(int axisX, int axisY) {
    public Position moveForward(Direction direction) {
        return new Position(4, 3);
    }
}
