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
}
