package com.codurance.yahtzee;

import com.codurance.yahtzee.scorer.ScoringCategory;
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

    @Test
    public void score_with_selected_strategy() {
        int[] diceRolls = {3, 3, 3, 3, 3};
        int expectedScore = 15;
        Yahtzee yahtzee = new Yahtzee(null);

        int score = yahtzee.scoreWith(ScoringCategory.THREES, diceRolls);

        assertEquals(expectedScore, score);
    }
}
