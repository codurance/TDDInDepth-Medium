import java.util.ArrayList;
import java.util.List;

class DenominationCollection {
    private final List<Money> availableDenominations = List.of(
        Money.bill(500),
        Money.bill(200),
        Money.bill(100),
        Money.bill(50),
        Money.bill(20),
        Money.bill(10),
        Money.bill(5),
        Money.coin(2),
        Money.coin(1)
    );

    public ArrayList<Money> selectDenominationsFor(int quantity) {
        ArrayList<Money> withdrawal = new ArrayList<>();

        for (Money denomination : availableDenominations) {
            while (quantity >= denomination.value()) {
                withdrawal.add(denomination);
                quantity -= denomination.value();
            }
        }
        return withdrawal;
    }
}
