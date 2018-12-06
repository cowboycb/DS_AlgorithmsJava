package com.techsoftcenter.util;

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

    public static void printArray(int[] array){
        System.out.print("[ ");
        for (int item: array) {
            System.out.print(item + "  ");
        }
        System.out.println("]");
    }

}
