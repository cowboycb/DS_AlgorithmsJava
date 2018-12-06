package com.techsoftcenter.selectionsort;

import com.techsoftcenter.util.SortUtil;

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

        SortUtil.fillArrayRandom(array, -50, 50);

        SortUtil.printArray(array);

        System.out.println("Selection sort started...");
        long startTime = System.nanoTime();
        sort(array);
        long endTime = System.nanoTime();
        long time_ns = endTime - startTime;
        System.out.println("Selection sort finished " + time_ns + " ns");
        System.out.println("--------------------------------------------");

        SortUtil.printArray(array);
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
                SortUtil.swap(array, minist, i);
            }
//            printArray(array);
        }
    }

}
