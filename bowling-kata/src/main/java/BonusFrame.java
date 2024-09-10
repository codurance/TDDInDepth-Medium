import java.util.Objects;

public class BonusFrame {
    private int firstRoll;
    private int secondRoll;
    private int lastRoll = 0;
    private int bonus = 0;

    public BonusFrame(int firstRoll, int secondRoll, int lastRoll, int bonus) {
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
        this.lastRoll = lastRoll;
        this.bonus = bonus;
    }

    public int score() {
        return firstRoll + secondRoll + lastRoll + bonus;
    }

    public int bonus() {
        return bonus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BonusFrame that = (BonusFrame) o;
        return firstRoll == that.firstRoll && secondRoll == that.secondRoll && lastRoll == that.lastRoll && bonus == that.bonus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstRoll, secondRoll, lastRoll, bonus);
    }
}
