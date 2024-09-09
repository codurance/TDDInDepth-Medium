import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AtmMachineShould {

    @Test
    public void withdraw_coin_worth_1() {
        AtmMachine atmMachine = new AtmMachine();
        List<Money> expectedWithdrawal = List.of(Money.coin(1));

        List<Money> withdrawal = atmMachine.withdraw(1);

        assertEquals(expectedWithdrawal, withdrawal);
    }

    @Test
    public void withdraw_combination_of_coins_worth_3() {
        AtmMachine atmMachine = new AtmMachine();
        List<Money> withdrawal = atmMachine.withdraw(3);

        List<Money> expectedWithdrawal = List.of(Money.coin(2), Money.coin(1));

        assertEquals(expectedWithdrawal, withdrawal);
    }
}