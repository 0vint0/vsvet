package com.vsvet.algorithm.sort;

/**
 * Worst case performance O(n^2)
 * Best case performance O(n)
 * @author vsvet
 *
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arrayToSort = { 11,2, 35, 3, 4, 23, 5, 4,60,0 };
        // Sort array asc
        for(int i= 1;i<arrayToSort.length;i++){
            for(int j=0;j<i;j++){
                if(arrayToSort[i]<arrayToSort[j]){
                    insert(arrayToSort, j, i);
                }
            }
        } 
        //               
        System.out.println("Sorted array:");
        for (int i = 0; i < arrayToSort.length; i++) {
            System.out.print(arrayToSort[i]+", ");
        }
    }
    
    private static void insert(int []array,int toIndex,int fromIndex){
        int toInsert = array[fromIndex];
        int nextValue = array[toIndex];
        for(int i = toIndex+1;i<=fromIndex;i++){
                int temp = array[i];
                array[i] = nextValue; 
                nextValue = temp;
        }
        array[toIndex]=toInsert;
    }
    
    //[2, 3, 4, 23, 35, 5, 4, 60, 0]
    //  0 1  2  3   4   5   6  7  8
//              >      >

}
