import org.junit.jupiter.api.Test;

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
    public void rotate() {
        MarsRover marsRover = new MarsRover();

        assertEquals(Direction.WEST, marsRover.direction());
    }
}
