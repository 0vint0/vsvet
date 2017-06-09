package com.vsvet.algorithm.sort;

/**
 * Worst case performance O(n^2) Best case performance O(n log n) Average performance O(n)
 * 
 * @author vsvet
 *
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arrayToSort = { 11, 2, 35, 3, 4, 23, 5, 4, 60, 0 };
        // Sort array asc
        partition(arrayToSort, 0, arrayToSort.length-1);
        //
        System.out.println("Sorted array:");
        for (int i = 0; i < arrayToSort.length; i++) {
            System.out.print(arrayToSort[i] + ", ");
        }
    }

    private static void partition(int[] array, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int pivotElementIndex = startIndex;
            int i = startIndex, j = endIndex;
            i++;
            while (i <= j) {
                //if right element is less then switch
                if ((array[i] < array[pivotElementIndex] && i>pivotElementIndex)||
                        //if left element is greater then switch
                        (array[i] > array[pivotElementIndex] && i<pivotElementIndex)) {
                    exchange(array, i, pivotElementIndex);
                    pivotElementIndex = i;
                }
                //if left element is greater then switch
                if ((array[j] > array[pivotElementIndex] && j<pivotElementIndex)||
                      //if right element is less then switch
                        (array[j] < array[pivotElementIndex] && j>pivotElementIndex)) {
                    exchange(array, j, pivotElementIndex);
                    pivotElementIndex = j;
                }
                i++;
                j--;
            }
            partition(array, startIndex, pivotElementIndex);
            partition(array, pivotElementIndex + 1, endIndex);
        }
    }
    
    private static void exchange(int[] array, int index1, int index2){
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }
    //11, 2, 35, 3, 4, 23, 5, 4, 60, 0
}
