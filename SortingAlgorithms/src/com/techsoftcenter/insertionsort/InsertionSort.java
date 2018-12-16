package com.techsoftcenter.insertionsort;

import com.techsoftcenter.util.SortUtil;

public class InsertionSort {

    public static void main(String[] args) {
        int[] array = new int[10];
        SortUtil.fillArrayRandom(array, -50, 50);

        SortUtil.printArray(array);

        System.out.println("Insertion sort started...");
        long startTime = System.nanoTime();
        sort(array);
        long endTime = System.nanoTime();
        long time_ns = endTime - startTime;
        System.out.println("Insertion sort finished " + time_ns + " ns");
        System.out.println("--------------------------------------------");
        SortUtil.printArray(array);

    }

    private static void sort(int[] array) {
        for (int i=1; i<array.length; i++){
            int key = array[i];
            int j=i;
            while(j>0 && key<array[j-1]){
                array[j] = array[j-1];
//                SortUtil.swap(array, j, j-1);
//                SortUtil.printArray(array);
                j--;
            }
            if (i != j) {
                array[j] = key;
            }
        }

    }

}
