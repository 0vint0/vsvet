package com.vsvet.algorithm.sort;

/**
 * Worst case performance O(n^2)
 * Best case performance O(n log n)
 * Average performance O(n)
 * @author vsvet
 *
 */
public class QuickSortBadOne {

    public static void main(String[] args) {
        int[] arrayToSort = { 11,2, 35, 3, 4, 23, 5, 4,60,0 };
        // Sort array asc
        arrayToSort = partition(arrayToSort);
        //               
        System.out.println("Sorted array:");
        for (int i = 0; i < arrayToSort.length; i++) {
            System.out.print(arrayToSort[i]+", ");
        }
    }
    
    private static int[] partition(int []array){
        if(array.length<=2){
            return  array;
        }
        int []leftPartition = new int[]{};
        int []rightPartition = new int[]{};
        int pivotElement = array[0];
        for(int i=1;i<array.length;i++){
            if(array[i]>pivotElement){
                rightPartition = add(rightPartition, array[i]);
            }
            else{
                leftPartition = add(leftPartition, array[i]);
            }
        }
        leftPartition = add(leftPartition, pivotElement);
        return merge(partition(leftPartition), partition(rightPartition));
    }
    
    private static int[] add(int []a, int val){
        int b[] = new int[a.length+1];
        for(int j=0;j<a.length;j++){
            b[j]=a[j];
        }
        b[a.length] = val;
        return b;
    }
    
    private static int[] merge(int []a1,int []a2){
        int []b = new int[a1.length+a2.length];
        for(int i = 0;i<b.length;i++){
            if(i<a1.length){
                b[i]=a1[i];
            }
            else{
                b[i]=a2[i-a1.length];
            }
        }
        return b;
    } 
    
    //[2, 3, 4, 23, 35, 5, 4, 60, 0]
    //  0 1  2  3   4   5   6  7  8
//              >      >

}
