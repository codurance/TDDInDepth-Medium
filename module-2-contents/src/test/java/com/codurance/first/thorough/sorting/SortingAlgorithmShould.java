package com.codurance.first.thorough.sorting;

import net.jqwik.api.*;
import net.jqwik.api.constraints.Size;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SortingAlgorithmShould {

    @Property
    public void testSortingAlgorithm(@ForAll @Size(min = 0, max = 1000) int[] array) {
        int[] sortedArray = SortingAlgorithm.sort(array);

        // Property 1: The array should be in non-decreasing order
        for (int i = 0; i < sortedArray.length - 1; i++) {
            assertTrue(sortedArray[i] <= sortedArray[i + 1], "Array should be sorted in non-decreasing order");
        }

        // Property 2: The sorted array should have the same elements as the input array
        assertTrue(hasSameElements(array, sortedArray), "Sorted array should contain the same elements as the input array");

        // Property 3: Sorting an already sorted array should result in the same array
        int[] resortedArray = SortingAlgorithm.sort(sortedArray);
        assertTrue(Arrays.equals(sortedArray, resortedArray), "Sorting an already sorted array should yield the same result");
    }

    private boolean hasSameElements(int[] original, int[] sorted) {
        int[] originalCopy = Arrays.copyOf(original, original.length);
        int[] sortedCopy = Arrays.copyOf(sorted, sorted.length);
        Arrays.sort(originalCopy);
        Arrays.sort(sortedCopy);
        return Arrays.equals(originalCopy, sortedCopy);
    }
}
