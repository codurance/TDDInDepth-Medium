import java.util.ArrayList;
import java.util.List;

public class AtmMachine {

    private final DenominationCollection denominationCollection;
    private final MoneyDispenser moneyDispenser;

    public AtmMachine(DenominationCollection denominationCollection, MoneyDispenser moneyDispenser) {
        this.denominationCollection = denominationCollection;
        this.moneyDispenser = moneyDispenser;
    }

    public void withdraw(int quantity) {
        ArrayList<Money> monies = denominationCollection.selectDenominationsFor(quantity);
        moneyDispenser.dispense(monies);
    }

}
