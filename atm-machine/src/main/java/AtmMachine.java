import java.util.List;

public class AtmMachine {

    private final DenominationCollection denominationCollection;

    public AtmMachine(DenominationCollection denominationCollection) {
        this.denominationCollection = denominationCollection;
    }

    public List<Money> withdraw(int quantity) {

        return denominationCollection.selectDenominationsFor(quantity);
    }

}
