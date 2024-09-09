import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsRoverShould {
    /**
     * You are given the initial starting point (x,y) of a rover and the direction (N,S,E,W) it is facing.
     * The rover receives a character array of commands.
     * Implement commands that move the rover forward/backward (f,b).
     * Implement commands that turn the rover left/right (l,r).
     * Implement wrapping at edges. But be careful, planets are spheres.
     */

    @Test
    public void move_forward() {
        MarsRover marsRover = new MarsRover(Direction.NORTH, new Position(3, 3));

        marsRover.execute("F");

        assertEquals(new Position(4, 3), marsRover.position());
    }

    @ParameterizedTest
    @MethodSource("getLeftRotations")
    public void rotate_to_left(Direction direction, Direction expectedDirection) {
        MarsRover marsRover = new MarsRover(direction, new Position(3, 3));

        marsRover.execute("L");

        assertEquals(expectedDirection, marsRover.direction());
    }

    @ParameterizedTest
    @MethodSource("getRightRotations")
    public void rotate_to_right(Direction direction, Direction expectedDirection) {
        MarsRover marsRover = new MarsRover(direction, new Position(3, 3));

        marsRover.execute("R");

        assertEquals(expectedDirection, marsRover.direction());
    }

    public static Stream<Arguments> getLeftRotations() {
        return Stream.of(
            Arguments.of(
                Direction.NORTH,
                Direction.WEST
            ),
            Arguments.of(
                Direction.WEST,
                Direction.SOUTH
            ),
            Arguments.of(
                Direction.SOUTH,
                Direction.EAST
            ),
            Arguments.of(
                Direction.EAST,
                Direction.NORTH
            )
        );
    }

    public static Stream<Arguments> getRightRotations() {
        return Stream.of(
            Arguments.of(
                Direction.NORTH,
                Direction.EAST
            ),
            Arguments.of(
                Direction.EAST,
                Direction.SOUTH
            ),
            Arguments.of(
                Direction.SOUTH,
                Direction.WEST
            ),
            Arguments.of(
                Direction.WEST,
                Direction.NORTH
            )
        );
    }

}
