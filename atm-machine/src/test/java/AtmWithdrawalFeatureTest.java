import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

public class AtmWithdrawalFeatureTest {
    @Test
    public void user_should_be_able_to_withdraw_money() {
        List<CashUnit> cashUnits = List.of(
            new CashUnit(Money.bill(500), 2),
            new CashUnit(Money.bill(200), 3),
            new CashUnit(Money.bill(100), 5),
            new CashUnit(Money.bill(50), 12),
            new CashUnit(Money.bill(20), 20),
            new CashUnit(Money.bill(10), 50),
            new CashUnit(Money.bill(5), 100),
            new CashUnit(Money.coin(2), 250),
            new CashUnit(Money.coin(1), 500)
        );
        MoneyDispenser moneyDispenser = mock(MoneyDispenser.class);
        DenominationCollection denominationCollection = new DenominationCollection(cashUnits);
        AtmMachine atmMachine = new AtmMachine(denominationCollection, moneyDispenser);

        atmMachine.withdraw(1725);

        atmMachine.withdraw(1825);

        InOrder inOrder = inOrder(moneyDispenser);

        inOrder.verify(moneyDispenser).dispense(
            List.of(
                Money.bill(500),
                Money.bill(500),
                Money.bill(200),
                Money.bill(200),
                Money.bill(200),
                Money.bill(100),
                Money.bill(20),
                Money.bill(5)
            )
        );
        inOrder.verify(moneyDispenser).dispense(
            Stream.of(
                Collections.nCopies(4, Money.bill(100)),
                Collections.nCopies(12, Money.bill(50)),
                Collections.nCopies(19, Money.bill(20)),
                Collections.nCopies(44, Money.bill(10)),
                Collections.nCopies(1, Money.bill(5))
            ).flatMap(Collection::stream).collect(Collectors.toList()
            )
        );
    }
}
