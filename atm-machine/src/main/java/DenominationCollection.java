import java.util.ArrayList;
import java.util.List;

class DenominationCollection {
    private final List<Money> availableDenominations = List.of(
        Money.bill(5),
        Money.coin(2),
        Money.coin(1)
    );

    public ArrayList<Money> selectDenominationsFor(int quantity) {
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
