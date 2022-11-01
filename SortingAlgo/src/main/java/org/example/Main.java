package org.example;

import Sort.MergeSort;

public class Main {
    public static void main(String[] args) {
        //Merge sort
        MergeSort ms = new MergeSort();

        int arr[] = {3, 2, 5, 1, 4, 6};

        int[] sorted = ms.mergeSort(arr);

        for(int i : sorted)
            System.out.println(i);

        
    }
}