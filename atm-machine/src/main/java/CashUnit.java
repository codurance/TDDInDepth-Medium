public class CashUnit {
    private final Money denomination;
    private int quantity;

    public CashUnit(Money denomination, int quantity) {
        this.denomination = denomination;
        this.quantity = quantity;
    }

    public int value() {
        return denomination.value();
    }

    public Money denomination() {
        return denomination;
    }

    public Money takeOne() {
        return denomination;
    }
}
