package com.techsoftcenter.shellsort;

import com.techsoftcenter.util.SortUtil;

public class ShellSort {

    public static void main(String[] args) {

        int[] array = new int[1000];
        SortUtil.fillArrayRandom(array, -250, 500);
//        SortUtil.fillArrayRandomUnique(array, -250, 500);

        SortUtil.printArray(array);

        System.out.println("Shell sort started...");
        long startTime = System.nanoTime();
        sort(array);
        long endTime = System.nanoTime();
        long time_ns = endTime - startTime;
        System.out.println("Shell sort finished " + time_ns + " ns");
        System.out.println("--------------------------------------------");
        SortUtil.printArray(array);
//        01.517.675
//        07.329.422
    }

    public static void sort(int[] array) {
        // http://www.wikizeroo.net/index.php?q=aHR0cDovL29laXMub3JnL0EwMDM0NjI
        int gapFirst = (array.length * 2 + 1) / 3;

        for (int gap = gapFirst; gap > 0; gap--) {

            for (int i = gap; i < array.length; i++) {
                int element = array[i];
                int j = i;
//                System.out.println("Element " + element);
                while (j >= gap && array[j - gap] > element) {
                    array[j] = array[j - gap];
//                    SortUtil.printArray(array);
                    j -= gap;
                }
                array[j] = element;
//                SortUtil.printArray(array);
            }
        }
    }
}
