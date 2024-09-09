import java.util.ArrayList;
import java.util.List;

public class AtmMachine {

    public List<Money> withdraw(int quantity) {
        DenominationCollection denominationCollection = new DenominationCollection();

        return denominationCollection.selectDenominationsFor(quantity);
    }

    private class DenominationCollection {
        private final List<Money> availableDenominations = List.of(Money.coin(2), Money.coin(1));

        private ArrayList<Money> selectDenominationsFor(int quantity) {
            ArrayList<Money> withdrawal = new ArrayList<>();

            for (Money denomination : availableDenominations) {
                if (quantity >= denomination.value()) {
                    withdrawal.add(denomination);
                    quantity -= denomination.value();
                }
            }
            return withdrawal;
        }
    }
}
