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
}