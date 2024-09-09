import java.util.ArrayList;
import java.util.List;

public class AtmMachine {
    private List<Money> availableDenominations = List.of(Money.coin(2), Money.coin(1));

    public List<Money> withdraw(int quantity) {
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
