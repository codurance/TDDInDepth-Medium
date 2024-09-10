public record Position(int axisX, int axisY) {
    public Position moveForward(Direction direction, Planet planet) {
        Position position = this;

        switch (direction) {
            case NORTH -> position = new Position(sumAxisIn(planet.longitude(), axisX), axisY);
            case EAST -> position = new Position(axisX, sumAxisIn(planet.latitude(), axisY));
            case SOUTH -> position = new Position(subAxisIn(planet.longitude(), axisX), axisY);
            case WEST -> position = new Position(axisX, subAxisIn(planet.latitude(), axisY));
        }

        return position;
    }

    public Position moveBackward(Direction direction, Planet planet) {
        Position position = this;

        switch (direction) {
            case NORTH -> position = new Position(subAxisIn(planet.longitude(), axisX), axisY);
        }

        return position;
    }

    private int subAxisIn(int planetSize, int axis) {
        axis = axis - 1;

        if (0 > axis) {
            return planetSize - 1;
        }

        return axis;
    }

    private int sumAxisIn(int planetSize, int axis) {
        axis = axis + 1;

        if (planetSize <= axis) {
            return 0;
        }

        return axis;
    }
}
