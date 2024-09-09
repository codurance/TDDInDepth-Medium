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

    @ParameterizedTest
    @MethodSource("getRotations")
    public void rotate_left(Direction direction, Direction expectedDirection) {
        MarsRover marsRover = new MarsRover(direction);

        marsRover.execute("L");

        assertEquals(expectedDirection, marsRover.direction());
    }

    public static Stream<Arguments> getRotations() {
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

}
