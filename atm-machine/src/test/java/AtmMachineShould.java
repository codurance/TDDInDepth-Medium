import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AtmMachineShould {

    private AtmMachine atmMachine;

    @BeforeEach
    void setUp() {
        atmMachine = new AtmMachine(new DenominationCollection());
    }

    @Test
    public void withdraw_coin_worth_1() {
        List<Money> expectedWithdrawal = List.of(Money.coin(1));

        List<Money> withdrawal = atmMachine.withdraw(1);

        assertEquals(expectedWithdrawal, withdrawal);
    }

    @Test
    public void withdraw_combination_of_coins_worth_3() {
        List<Money> withdrawal = atmMachine.withdraw(3);

        List<Money> expectedWithdrawal = List.of(Money.coin(2), Money.coin(1));

        assertEquals(expectedWithdrawal, withdrawal);
    }
}