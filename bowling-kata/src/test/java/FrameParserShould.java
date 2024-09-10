import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FrameParserShould {
    @Test
    public void parse_perfect_game_frames_from_rolls() {

        FrameParser frameParse = new FrameParser();

        List<Integer> rolls = Collections.nCopies(12, 10);

        Frames frames = frameParse.getFramesOf(rolls);

        assertEquals(List.of(
            new Frame(10, 0),
            new Frame(10, 0),
            new Frame(10, 0),
            new Frame(10, 0),
            new Frame(10, 0),

            new Frame(10, 0),
            new Frame(10, 0),
            new Frame(10, 0),
            new Frame(10, 0),
            new Frame(10, 10, 10)
        ), frames.all());
    }

    @Test
    public void parse_all_spare_game_frames_from_rolls() {

        FrameParser frameParse = new FrameParser();

        List<Integer> rolls = Collections.nCopies(21, 5);

        Frames frames = frameParse.getFramesOf(rolls);

        assertEquals(List.of(
            new Frame(5, 5),
            new Frame(5, 5),
            new Frame(5, 5),
            new Frame(5, 5),
            new Frame(5, 5),

            new Frame(5, 5),
            new Frame(5, 5),
            new Frame(5, 5),
            new Frame(5, 5),
            new Frame(5, 5, 5)
        ), frames.all());
    }
}
