package com.vsvet.algorithm.sort;

/**
 * Worst case performance O(n^2)
 * Best case performance O(n^2)
 * @author vsvet
 *
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arrayToSort = { 2, 35, 3, 4, 23, 5, 4,60,0 };
        // Sort array asc
        for (int i = 0; i < arrayToSort.length - 1; i++) {
            for (int j = i + 1; j < arrayToSort.length; j++) {
                if (arrayToSort[i] > arrayToSort[j]) {
                    int temp = arrayToSort[i];
                    arrayToSort[i] = arrayToSort[j];
                    arrayToSort[j] = temp;
                }
            }
        }
        System.out.println("Sorted array:");
        for (int i = 0; i < arrayToSort.length; i++) {
            System.out.print(arrayToSort[i]+", ");
        }

    }

}
