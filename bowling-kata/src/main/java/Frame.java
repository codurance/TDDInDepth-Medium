public class Frame {
    private final Integer firstRoll;
    private final Integer secondRoll;
    private Integer lastRoll = 0;

    public Frame(Integer firstRoll, Integer secondRoll) {
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
    }

    public Frame(int firstRoll, Integer secondRoll, Integer lastRoll) {
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
        this.lastRoll = lastRoll;
    }

    public int sumRolls() {
        return firstRoll + secondRoll;
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
}
