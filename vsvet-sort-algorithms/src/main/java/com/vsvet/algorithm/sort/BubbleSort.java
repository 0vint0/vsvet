package com.vsvet.algorithm.sort;

// @formatter:off
/**
 * Worst case performance O(n ^2)
 * Best case performance O(n) 
 * Average performance O(n ^2)
 * 
 * @author vsvet
 *
 */
//@formatter:on
public class BubbleSort {

    public static void main(String[] args) {
        int[] arrayToSort = { 11, 20, -1,35, 3,100, 4, 23, 5, 4, 60, 0 };
//        int[] arrayToSort = { 3,0,5,4};
        // Sort array asc
        for(int i=0;i<arrayToSort.length;i++){
            for(int j=0;j<arrayToSort.length-i-1;j++){
                if(arrayToSort[j]>arrayToSort[j+1]){
                    exchange(arrayToSort, j, j+1);
                }
            }
        }
        System.out.println("Sorted array:");
        for (int i = 0; i < arrayToSort.length; i++) {
            System.out.print(arrayToSort[i] + ", ");
        }
    }
    

    private static void exchange(int[] array, int index1, int index2){
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }
    //11, 2, 35, 3, 4, 23, 5, 4, 60, 0
    //0   1  2  3   4  5   6  7  8   9
}
