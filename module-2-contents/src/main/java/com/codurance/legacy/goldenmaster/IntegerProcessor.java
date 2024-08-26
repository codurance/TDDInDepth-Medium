package com.codurance.legacy.goldenmaster;

import java.util.List;

public class IntegerProcessor {
    public int process(List<Integer> numbers) {
        int processedTotal = 0;
        for (int number : numbers) {
            if (isGreaterThanAHundred(number)) {
                processedTotal += number * 2;
            } else if (isSmallerThanAMinusHundred(number)) {
                processedTotal -= number / 2;
            } else if (isGreaterThanZero(number)) {
                processedTotal += number;
            } else if (isSmallerThanZero(number)) {
                processedTotal -= number;
            }
        }
        return processedTotal;
    }

    private static boolean isSmallerThanZero(int number) {
        return number < 0;
    }

    private static boolean isGreaterThanZero(int number) {
        return number > 0;
    }

    private static boolean isSmallerThanAMinusHundred(int number) {
        return number < -100;
    }

    private static boolean isGreaterThanAHundred(int number) {
        return number > 100;
    }
}
