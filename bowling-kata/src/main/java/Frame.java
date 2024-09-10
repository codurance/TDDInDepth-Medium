import java.util.Objects;

public class Frame {
    private final Integer firstRoll;
    private final Integer secondRoll;
    private Integer lastRoll = 0;
    private boolean isLastFrame = false;

    public Frame(Integer firstRoll, Integer secondRoll) {
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
    }

    public Frame(int firstRoll, Integer secondRoll, Integer lastRoll) {
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
        this.lastRoll = lastRoll;
        isLastFrame = true;
    }

    public int firstRoll() {
        return firstRoll;
    }

    public boolean isSpare() {
        return !isStrike() && firstRoll + secondRoll == 10;
    }

    public boolean isStrike() {
        return firstRoll == 10;
    }

    public int secondRoll() {
        return secondRoll;
    }

    public int lastRoll() {
        return lastRoll;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Frame frame = (Frame) o;
        return Objects.equals(firstRoll, frame.firstRoll) && Objects.equals(secondRoll, frame.secondRoll) && Objects.equals(lastRoll, frame.lastRoll);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstRoll, secondRoll, lastRoll);
    }

    public boolean isLastFrame() {
        return isLastFrame;
    }
}
