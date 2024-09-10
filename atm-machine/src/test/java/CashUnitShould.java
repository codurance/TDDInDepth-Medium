import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CashUnitShould {
    @Test
    public void not_allow_taking_denomination_when_quantity_0() {
        CashUnit cashUnit = new CashUnit(Money.bill(100), 0);

        assertThrows(CashUnitNotAvailableException.class, cashUnit::takeOne);
    }
}