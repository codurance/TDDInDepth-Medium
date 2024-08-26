package com.codurance.legacy.goldenmaster;

import java.util.List;

public class IntegerProcessor {
    public int p(List<Integer> l) {
        int r = 0;
        for (int n : l) {
            if (n > 100) {
                r += n * 2;
            } else if (n < -100) {
                r -= n / 2;
            } else if (n > 0) {
                r += n;
            } else if (n < 0) {
                r -= n;
            }
        }
        return r;
    }
}
