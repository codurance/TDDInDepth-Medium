import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

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

    @ParameterizedTest
    @MethodSource("combinationsProvider")
    public void withdraw_combination_of_coins_and_bills(int quantity, List<Money> expectedWithdrawal) {
        atmMachine.withdraw(quantity);

        verify(moneyDispenser).dispense(expectedWithdrawal);
    }

    public static Stream<Arguments> combinationsProvider() {
        return Stream.of(
            Arguments.of(3, List.of(Money.coin(2), Money.coin(1))),
            Arguments.of(30, List.of(Money.bill(20), Money.bill(10))),
            Arguments.of(99, List.of(
                Money.bill(50),
                Money.bill(20),
                Money.bill(20),
                Money.bill(5),
                Money.coin(2),
                Money.coin(2)
            )),
            Arguments.of(444, List.of(
                Money.bill(200),
                Money.bill(200),
                Money.bill(20),
                Money.bill(20),
                Money.coin(2),
                Money.coin(2)
            ))
        );
    }
}