public record Position(int axisX, int axisY) {
    public Position moveForward(Direction direction, Planet planet) {
        return switch (direction) {
            case NORTH -> new Position(sumAxisIn(planet.longitude(), axisX), axisY);
            case EAST -> new Position(axisX, sumAxisIn(planet.latitude(), axisY));
            case SOUTH -> new Position(subAxisIn(planet.longitude(), axisX), axisY);
            case WEST -> new Position(axisX, subAxisIn(planet.latitude(), axisY));
        };
    }

    public Position moveBackward(Direction direction, Planet planet) {
        return switch (direction) {
            case NORTH -> new Position(subAxisIn(planet.longitude(), axisX), axisY);
            case WEST -> new Position(axisX, sumAxisIn(planet.latitude(), axisY));
            case SOUTH -> new Position(sumAxisIn(planet.longitude(), axisX), axisY);
            case EAST -> new Position(axisX, subAxisIn(planet.latitude(), axisY));
        };
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
