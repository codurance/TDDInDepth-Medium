import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class AtmMachineShould {

    private AtmMachine atmMachine;
    private MoneyDispenser moneyDispenser;

    @BeforeEach
    void setUp() {
        moneyDispenser = mock(MoneyDispenser.class);
        atmMachine = new AtmMachine(new DenominationCollection(), moneyDispenser);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    public void withdraw_single_coin(int coinValue) {
        List<Money> expectedWithdrawal = List.of(Money.coin(coinValue));

        atmMachine.withdraw(coinValue);

        verify(moneyDispenser).dispense(expectedWithdrawal);
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 10, 20, 50, 100, 200, 500})
    public void withdraw_individual_bill(int billValue) {
        atmMachine.withdraw(billValue);

        List<Money> expectedWithdrawal = List.of(Money.bill(billValue));

        verify(moneyDispenser).dispense(expectedWithdrawal);
    }

    @Test
    public void withdraw_combination_of_coins_worth_3() {
        atmMachine.withdraw(3);

        List<Money> expectedWithdrawal = List.of(Money.coin(2), Money.coin(1));

        verify(moneyDispenser).dispense(expectedWithdrawal);
    }
}