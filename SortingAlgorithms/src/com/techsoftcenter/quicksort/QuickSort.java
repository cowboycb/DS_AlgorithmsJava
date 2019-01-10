package com.techsoftcenter.quicksort;

import com.techsoftcenter.util.SortUtil;

public class QuickSort {

    public static void main(String[] args) {

        int[] array = new int[1000];
        SortUtil.fillArrayRandom(array, -750, 1500);

        SortUtil.printArray(array);

        System.out.println("Quick sort started...");
        long startTime = System.nanoTime();
        sort(array, 0, array.length);
        long endTime = System.nanoTime();
        long time_ns = endTime - startTime;
        System.out.println("Quick sort finished " + time_ns + " ns");
        System.out.println("--------------------------------------------");
        SortUtil.printArray(array);

    }

    public static void sort(int[] array, int low, int high) {

        if (high - low < 2) {
            return;
        }

        int p = partition(array, low, high);

        sort(array, low, p);
        sort(array, p + 1, high);

    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[low];

        int i = low, j = high;

        while (j > i) {

            while (j > i && array[--j] > pivot) ;
            if (j > i) {
                array[i] = array[j];
            }
            while (j > i && array[++i] <= pivot) ;

            if (j > i) {
                array[j] = array[i];
            }
        }
        array[j] = pivot;
        return j;

    }
}
