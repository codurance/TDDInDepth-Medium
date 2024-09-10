import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DenominationCollectionShould {
    @Test
    public void only_select_available_denominations() {
        List<CashUnit> cashUnits = List.of(
            new CashUnit(Money.bill(500), 1),
            new CashUnit(Money.bill(200), 1),
            new CashUnit(Money.bill(100), 2),
            new CashUnit(Money.bill(50), 2)
        );
        DenominationCollection denominationCollection = new DenominationCollection(cashUnits);
        List<Money> expectedDenominations = List.of(
            Money.bill(500),
            Money.bill(200),
            Money.bill(100),
            Money.bill(100),
            Money.bill(50),
            Money.bill(50));

        List<Money> availableDenominations = denominationCollection.selectDenominationsFor(1000);

        assertEquals(expectedDenominations, availableDenominations
        );
    }
}