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
public class HeapSort {

    public static void main(String[] args) {
        int[] arrayToSort = { 11, 20, -1,35, 3,100, 4, 23, 5, 4, 60, 0 };
//        int[] arrayToSort = { 0,3,4};
        // Sort array asc
        sort(arrayToSort);
        System.out.println("Sorted array:");
        for (int i = 0; i < arrayToSort.length; i++) {
            System.out.print(arrayToSort[i] + ", ");
        }
    }
    
    
    private static void sort(int[] arrayToSort){
        for(int i = 1;i<arrayToSort.length;i++){
            if(arrayToSort.length-i==3){
                System.out.println();
            }
            heapifyMaxDown(arrayToSort, 0,arrayToSort.length-i);
            exchange(arrayToSort, 0, arrayToSort.length-i);
        }
    }
    
    private static void heapifyMaxDown(int[] input,int index,int size) {
        if(index<0|| index>=size){
            return;
        }
        int leftIndexChild = index*2+1;
        int rightIndexChild = index*2+2;
        //check left child
        if(leftIndexChild<=size&&input[index]<input[leftIndexChild]){
            exchange(input, index, leftIndexChild);
            //verify its parent
            heapifyMaxUp(input, index,size);
        }
        //check right child
        if(rightIndexChild<=size&&input[index]<input[rightIndexChild]){
            exchange(input, index, rightIndexChild);
//            verify its parent
            heapifyMaxUp(input, index,size);
        }
        //going down through tree
        heapifyMaxDown(input, leftIndexChild,size);
        heapifyMaxDown(input, rightIndexChild,size);
    }
    
    //going up through tree checks if parent is not less than current child (on position index)
    private static void heapifyMaxUp(int[] input,int index,int size) {
        if(index<0){
            return;
        }
        //if index is even number than it's right child of his parent, otherwise it's left 
        int parentIndex=((index%2==0)?(index-2):(index-1))/2;
        if(parentIndex>=0&&input[parentIndex]<input[index]){
            //if parent is less then exchange
            exchange(input, parentIndex, index);
            heapifyMaxUp(input, parentIndex, size);
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
