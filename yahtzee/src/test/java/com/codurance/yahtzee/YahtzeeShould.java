package com.codurance.yahtzee;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class YahtzeeShould {
    @Test
    public void roll_five_dice() {
        DiceCup diceCup = mock(DiceCup.class);
        int[] expectedRoll = {1, 2, 3, 4, 5};
        when(diceCup.roll(5)).thenReturn(expectedRoll);
        Yahtzee yahtzee = new Yahtzee(diceCup);

        int[] roll = yahtzee.roll(5);

        verify(diceCup).roll(5);
        assertEquals(expectedRoll, roll);
    }

}
