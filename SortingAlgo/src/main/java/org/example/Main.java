package org.example;

import Sort.MergeSort;
import Sort.QuickSort;

public class Main {
    public static void main(String[] args) {
        int arr[] = {3, 2, 5, 1, 4, 6};

        //Merge sort
        System.out.println("Merge sort");
        MergeSort ms = new MergeSort();
        int[] sorted = ms.mergeSort(arr);

        for(int i : sorted)
            System.out.print(i+" ");

        System.out.println();

        //Quick sort
        System.out.println("Quick sort");
        QuickSort qs = new QuickSort();
        qs.quickSort(arr, 0, arr.length-1);

        for(int i : arr)
            System.out.print(i+" ");
    }
}