import java.util.List;

public class AtmMachine {
    public List<Money> withdraw(int quantity) {
        return List.of(Money.coin(quantity));
    }
}
