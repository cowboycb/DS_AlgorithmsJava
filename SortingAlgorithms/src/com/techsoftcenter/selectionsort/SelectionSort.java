package com.techsoftcenter.selectionsort;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Time Complexity: O(n*n)
 * Auxiliary Space: O(1)
 * Sorting In Place: Yes
 * Stable: No
 *
 * The good thing about selection sort is
 * it never makes more than O(n) swaps and can be useful when memory write is a costly operation.
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] array = new int[10];

        fillArrayRandom(array, -50, 50);

        printArray(array);

        System.out.println("Selection sort started...");
        long startTime = System.nanoTime();
        sort(array);
        long endTime = System.nanoTime();
        long time_ns = endTime - startTime;
        System.out.println("Selection sort finished " + time_ns + " ns");
        System.out.println("--------------------------------------------");

        printArray(array);
    }

    private static void sort(int[] array){
        for (int i=0; i<array.length; i++){
            int minist = i;
//            System.out.println("Min " + array[minist]);
            for (int j=i+1; j<array.length; j++){
//                System.out.println("array["+j+"]<array["+minist+"] " + (array[j]<array[minist]));
                if (array[j]<array[minist]){
                    minist = j;
//                    System.out.println("Min " + array[minist]);
                }
            }
            if (minist != i ){
                swap(array, minist, i);
            }
//            printArray(array);
        }
    }


    private static void swap(int[] array, int first, int second) {
        if (array[first] != array[second]) {
            int temp = array[second];
            array[second] = array[first];
            array[first] = temp;
        }
    }

    private static void fillArrayRandom(int[] arr, int min, int max){
        for (int i=0; i<arr.length; i++){
            int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
            arr[i] = randomNum;
        }
    }

    private static void printArray(int[] array){
        System.out.print("[ ");
        for (int item: array) {
            System.out.print(item + "  ");
        }
        System.out.println("]");
    }
}
