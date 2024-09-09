import java.util.Objects;

public final class Money {
    private final String type;
    private final int value;

    private Money(String type, int value) {
        this.type = type;
        this.value = value;
    }

    public String type() {
        return type;
    }

    public int value() {
        return value;
    }

    public static Money coin(int value) {
        return new Money("coin", value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Money) obj;
        return Objects.equals(this.type, that.type) &&
            this.value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, value);
    }

    @Override
    public String toString() {
        return "Money[" +
            "type=" + type + ", " +
            "value=" + value + ']';
    }

}
