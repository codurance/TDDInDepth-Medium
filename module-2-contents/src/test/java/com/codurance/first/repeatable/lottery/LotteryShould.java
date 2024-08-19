package com.codurance.first.repeatable.lottery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class LotteryShould {
    private RandomNumberGenerator randomNumberGenerator;
    private Lottery lottery;
    @BeforeEach
    public void setup() {
        randomNumberGenerator = mock(RandomNumberGenerator.class);
        lottery = new Lottery(randomNumberGenerator);

    }

    @Test
    public void createRandomTicketNumbers() {
        when(randomNumberGenerator.generateThreeDigitsNumber()).thenReturn(234, 658);

        assertEquals(234, lottery.createTicket());
        assertEquals(658, lottery.createTicket());

        verify(randomNumberGenerator, times(2)).generateThreeDigitsNumber();
    }

    @Test
    public void createWinningNumbers() {
        when(randomNumberGenerator.generateSingleDigitNumber()).thenReturn(2, 6, 1);

        assertEquals(162, lottery.winningNumber());

        verify(randomNumberGenerator, times(3)).generateSingleDigitNumber();
    }
}
