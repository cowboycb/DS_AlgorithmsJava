package com.techsoftcenter.mergesort;

import com.techsoftcenter.util.SortUtil;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        int[] array = new int[1000];
        SortUtil.fillArrayRandom(array, -250, 500);

        SortUtil.printArray(array);

        System.out.println("Merge sort started...");
        long startTime = System.nanoTime();
        array = sort(array);
        long endTime = System.nanoTime();
        long time_ns = endTime - startTime;
        System.out.println("Merge sort finished " + time_ns + " ns");
        System.out.println("--------------------------------------------");
        SortUtil.printArray(array);

    }

    public static int[] sort(int[] array){

        // if length of array is one then return it
        if (array.length==1) return array;
        int middle = (0 + array.length)/2;


        // Split array into two sub arrays
        int[] left = new int[middle];
        int[] right = new int[array.length - middle];

        for (int i=0; i<middle; i++){
            left[i] = array[i];
        }

        for (int i=middle; i<array.length; i++){
            right[i-middle] = array[i];
        }

        // go on splitting until length of array is 1
        left = sort(left);
        right = sort(right);


        // merge left and right sub arrays
        return merge(left, right);


    }

    public static int[] merge(int[] left, int[] right){
        int[] result = new int[left.length + right.length];


        int l = 0, r = 0;
        int resCounter = 0;
        while(l<left.length && r<right.length){
            if (left[l]<right[r]){
                result[resCounter] = left[l];
                l++;
            }else{
                result[resCounter] = right[r];
                r++;
            }
            resCounter++;
        }

        while (l<left.length){
            result[resCounter++] = left[l++];
        }

        while (r<right.length){
            result[resCounter++] = right[r++];
        }

        return result;
    }
}
