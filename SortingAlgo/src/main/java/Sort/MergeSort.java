package Sort;

import java.util.Arrays;

public class MergeSort {
    public int[] mergeSort(int[] arr){
        int size = arr.length;

        //recursion break
        if(size == 1)
            return arr;

        //copy half of arr to divide it
        int[] arr1 = Arrays.copyOfRange(arr, 0, size/2);
        int[] arr2 = Arrays.copyOfRange(arr, size/2, size);

        //recursively divide the array until each array has one element
        arr1 = mergeSort(arr1);
        arr2 = mergeSort(arr2);

        //recursively reconstruct the array in a sorted way
        return merge(arr1, arr2);
    }

    private int[] merge(int arr1[], int arr2[]){
        int size = arr1.length + arr2.length;
        int[] sortedArray = new int[size];

        //sort between 1 & 2, then put the sorted elements into sorted
        int arr1Size = arr1.length;
        int arr2Size = arr2.length;
        int i = 0, k = 0, l = 0;
        //We don't know which array is big or small, we finish with one
        while(arr1Size > k && arr2Size > l){
            if(arr1[k] > arr2[l]){
                sortedArray[i] = arr1[k];
                k++;
            }
            else{
                sortedArray[i] = arr2[l];
                l++;
            }
            i++;
        }

        //then if there are remaining elements in both array, empty them
        while(arr1Size > k){
            sortedArray[i] = arr1[k];
            k++;
            i++;
        }
        while (arr2Size > l){
            sortedArray[i] = arr2[l];
            l++;
            i++;
        }

        return sortedArray;
    }
}
