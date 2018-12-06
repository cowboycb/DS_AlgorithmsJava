package com.techsoftcenter.bubblesort;

import com.techsoftcenter.util.SortUtil;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Worst and Average Case Time Complexity: O(n*n). Worst case occurs when array is reverse sorted.
 * Best Case Time Complexity: O(n). Best case occurs when array is already sorted.
 * Auxiliary Space: O(1)
 * Boundary Cases: Bubble sort takes minimum time (Order of n) when elements are already sorted.
 * Sorting In Place: Yes
 * Stable: Yes
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = new int[10];

        SortUtil.fillArrayRandom(array, -50, 50);

        SortUtil.printArray(array);

        System.out.println("Bubble sort started...");
        long startTime = System.nanoTime();
        sort(array);
        long endTime = System.nanoTime();
        long time_ns = endTime - startTime;
        System.out.println("Bubble sort finished " + time_ns + " ns");
        System.out.println("--------------------------------------------");

        SortUtil.printArray(array);

        System.out.println("Improved Bubble sort started...");
        startTime = System.nanoTime();
        optimizedSort(array);
        endTime = System.nanoTime();
        time_ns = endTime - startTime;
        System.out.println("Improved Bubble sort finished " + time_ns + " ns");

        SortUtil.printArray(array);

        System.out.println("Recursive Bubble sort started...");
        startTime = System.nanoTime();
        recursiveSort(array, array.length);
        endTime = System.nanoTime();
        time_ns = endTime - startTime;
        System.out.println("Recursive Bubble sort finished " + time_ns + " ns");

        SortUtil.printArray(array);
    }

    private static void sort(int[] array) {
        for(int i=0; i<array.length-1; i++){
            for (int j=0; j<array.length - i - 1; j++){
//                printArray(array);
                if (array[j]>array[j+1]) {
                    SortUtil.swap(array, j, j+1);
                }
            }
        }
    }

    private static void recursiveSort(int array[], int length){
        if (length == 1){
            return;
        }

        for(int i=0; i<length-1; i++){
            if (array[i]>array[i+1]) {
                SortUtil.swap(array, i, i+1);
            }
        }
        recursiveSort(array, length -1);
    }

    private static void optimizedSort(int array[])
    {
        boolean swapped;
        int n = array.length;
        for (int i = 0; i < n - 1; i++)
        {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++)
            {
                if (array[j] > array[j + 1])
                {
                    SortUtil.swap(array, j, j+1);
                    swapped = true;
                }
            }

            // IF no two elements were
            // swapped by inner loop, then break
            if (!swapped)
                break;
        }
    }

}
