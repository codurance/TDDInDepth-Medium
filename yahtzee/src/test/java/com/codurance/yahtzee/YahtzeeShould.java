package com.codurance.yahtzee;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class YahtzeeShould {
    @Test
    public void roll_five_dice() {
        DiceCup diceCup = mock(DiceCup.class);
        Display display = mock(Display.class);
        Yahtzee yahtzee = new Yahtzee(diceCup, display);

        yahtzee.roll(5);

        verify(diceCup).roll(5);
    }

    @Test
    public void display_dice_rolled_by_player() {
        DiceCup diceCup = mock(DiceCup.class);
        Display display = mock(Display.class);
        Yahtzee yahtzee = new Yahtzee(diceCup, display);
        int[] roll = {1, 2, 3, 4, 5};
        when(diceCup.roll(5)).thenReturn(roll);

        yahtzee.roll(5);

        verify(display).displayRoll(roll);
    }
}
