package com.codurance.yahtzee;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class YahtzeeShould {
    @Test
    public void roll_five_dice() {
        DiceCup diceCup = mock(DiceCup.class);
        Yahtzee yahtzee = new Yahtzee(diceCup);

        yahtzee.roll(5);

        verify(diceCup).roll(5);
    }
}
