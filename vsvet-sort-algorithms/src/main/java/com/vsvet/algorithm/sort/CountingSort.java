package com.vsvet.algorithm.sort;

// @formatter:off
/**
 * Worst case performance O(n+k) 
 * Best case performance O(n+k) 
 * Average performance O(n+k) 
 * 
 * n- number of elements
 * k- the range 
 * 
 * 
 * 
 * @author vsvet
 *
 */
//@formatter:on
public class CountingSort {

    public static void main(String[] args) {
        int[] arrayToSort = { 11, 20, -1,35, 3,100, 4, 23, 5, 4, 60, 0 };
//        int[] arrayToSort = { 1,0,-1,2 ,-34,-5,33,2,1,-9,3,0,0,-9,3,4,1};
        int[] sortedArray = new int[arrayToSort.length];
        int maxElementToSort = 100;
        // Sort array asc
        int[] arrayOfFrequency = buildArrayOfFrequency(arrayToSort, maxElementToSort);
        reBuildArrayOfSumFrequency(arrayOfFrequency);
        for(int i=0;i<arrayToSort.length;i++){
            int positionInFrequency = position(arrayToSort[i],arrayOfFrequency.length);
            int sortedPosition = arrayOfFrequency[positionInFrequency]; 
            sortedArray[sortedPosition-1] =  arrayToSort[i];
            arrayOfFrequency[positionInFrequency]=--arrayOfFrequency[positionInFrequency];
        }
        
        System.out.println("Sorted array");
        for (int i = 0; i < sortedArray.length; i++) {
            System.out.print(sortedArray[i] + ", ");
        }
    }
    
    private static void reBuildArrayOfSumFrequency(int []input){
        int sum = 0;
        for(int i=0;i<input.length;i++){
            sum+=input[i];
            input[i]=sum;
        }
        
    }
    
    private static int[] buildArrayOfFrequency(int []input,int maxElementTosort){
        //+1 for 0
        int size = maxElementTosort*2+1;
        int[] output = new int[size];
        for(int i=0;i<input.length;i++){
                output[position(input[i],size)]++;
        }
        return output;
    }
    
    //Get a position in array of frequency 
    //It accepte negative numbers too
//    Ex: array of max 2 will have 5 elements
//    0  1  2  3  4     which will represent next:
//   -2 -1  0  1  2
    private static int position(int index,int arraySize){
       int zeroPosition  = (arraySize-1)/2;
       return zeroPosition+index;
    }
    
    //11, 2, 35, 3, 4, 23, 5, 4, 60, 0
    //0   1  2  3   4  5   6  7  8   9
}
