import java.util.ArrayList;

public class AtmMachine {

    private final CashCollection denominationCollection;
    private final MoneyDispenser moneyDispenser;

    public AtmMachine(CashCollection denominationCollection, MoneyDispenser moneyDispenser) {
        this.denominationCollection = denominationCollection;
        this.moneyDispenser = moneyDispenser;
    }

    public void withdraw(int quantity) {
        ArrayList<Money> monies = denominationCollection.selectDenominationsFor(quantity);
        moneyDispenser.dispense(monies);
    }

}
