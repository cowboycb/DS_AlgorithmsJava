package com.techsoftcenter.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class SortUtil {

    public static void swap(int[] array, int first, int second) {
        if (array[first] != array[second]) {
            int temp = array[second];
            array[second] = array[first];
            array[first] = temp;
        }
    }

    public static void fillArrayRandom(int[] arr, int min, int max){
        for (int i=0; i<arr.length; i++){
            int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
            arr[i] = randomNum;
        }
    }

    public static void fillArrayRandomUnique(int[] arr, int min, int max){
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<arr.length; i++){
            int randomNum = 0;
            do {
                randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
            }while (set.contains(randomNum));
            arr[i] = randomNum;
            set.add(randomNum);
        }
    }

    public static void printArray(int[] array){
//        System.out.println(Arrays.toString(array));
        System.out.print("[ ");
        for (int item: array) {
            System.out.print(item + "  ");
        }
        System.out.println("]");
    }


    /**
     * Inversion Count for an array indicates – how far (or close) the array is from being sorted.
     * <br/>If array is already sorted then inversion count is 0.
     * <br/>If array is sorted in reverse order that inversion count is the maximum.
     * @param arr Integer array
     * @return int inversionCount
     */
    public static int getInversionCount(int[] arr){
        int invCount = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i]>arr[j]){
                    invCount++;
                }
            }
        }
        return invCount;
    }



}
