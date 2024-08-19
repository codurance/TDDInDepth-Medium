package com.codurance.first.thorough.sorting;

import java.util.Arrays;

public class SortingAlgorithm {

    public static int[] sort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int[] arrayCopy = Arrays.copyOf(array, array.length);
        quickSort(arrayCopy, 0, arrayCopy.length - 1);
        return arrayCopy;
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
