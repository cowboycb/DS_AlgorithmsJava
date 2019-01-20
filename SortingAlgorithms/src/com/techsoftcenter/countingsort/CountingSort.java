package com.techsoftcenter.countingsort;

import com.techsoftcenter.util.SortUtil;

import java.util.Arrays;

public class CountingSort {

    public static void main(String[] args) {
        int[] array = new int[10];

        SortUtil.fillArrayRandom(array, 1, 50);

        SortUtil.printArray(array);

        System.out.println("Counting sort started...");
        long startTime = System.nanoTime();
        array = sort(array);
        long endTime = System.nanoTime();
        long time_ns = endTime - startTime;
        System.out.println("Counting sort finished " + time_ns + " ns");
        System.out.println("--------------------------------------------");

        SortUtil.printArray(array);

    }
    
    private static int[] sort(int[] array){
        int[] count = new int[50];
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            ++count[array[i]];
        }
//        SortUtil.printArray(count);

        for (int i=1; i<=count.length-1; ++i){
            count[i] += count[i-1];
        }

        for (int i = 0; i < result.length; i++) {
            result[count[array[i]]-1] = array[i];
            count[array[i]]--;
        }

        return result;
    }
}
