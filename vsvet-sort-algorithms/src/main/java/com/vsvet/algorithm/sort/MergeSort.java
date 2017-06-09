package com.vsvet.algorithm.sort;

// @formatter:off
/**
 * Worst case performance O(n log n)
 * Best case performance O(n log n) 
 * Average performance O(n log n)
 * 
 * @author vsvet
 *
 */
//@formatter:on
public class MergeSort {

    public static void main(String[] args) {
        int[] arrayToSort = { 11, 2, 35, 3, 4, 23, 5, 4, 60, 0 };
        // Sort array asc
        
        int [][]toMerge = split(arrayToSort);
        while (toMerge.length>1) {
          toMerge = merge(toMerge);
        }
        arrayToSort = toMerge[0];
        System.out.println("Sorted array:");
        for (int i = 0; i < arrayToSort.length; i++) {
            System.out.print(arrayToSort[i] + ", ");
        }
    }
    
    
    private static int[][] merge(int[][] in) {
        int size = (in.length%2==0)?in.length/2:in.length/2+1;
        int [][]out = new int[size][];
        int j = 0;
        for(int i=0;i<in.length;i+=2){
            if(i+1<in.length){
                out[j++]=merge(in[i], in[i+1]);
            }
            else{
                out[j++]=in[i];
            }
        }
        return out;
    }
    
    private static int[][] split(int []input){
        int [][]output = new int[input.length][1];
        for(int i=0;i<input.length;i++){
            output[i][0]=input[i];
        }
        return output;
    }
    
    private static int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int ai = 0, bi = 0;
        for (int i = 0; i < c.length; i++) {
            if (ai < a.length && bi < b.length) {
                if (a[ai] < b[bi]) {
                    c[i] = a[ai];
                    ai++;
                } else {
                    c[i] = b[bi];
                    bi++;
                }
            } else if (ai < a.length) {
                c[i] = a[ai];
                ai++;
            } else if (bi < b.length) {
                c[i] = b[bi];
                bi++;
            }
        }
        return c;
    }
}
