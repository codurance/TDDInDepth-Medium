public class Frame {
    private final Integer firstRoll;
    private final Integer secondRoll;

    public Frame(Integer firstRoll, Integer secondRoll) {

        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
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
}
