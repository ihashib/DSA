package Heap;

import java.util.Arrays;

public class MinHeap {
    int heapSize = 10;
    int[] heap = new int[heapSize];
    int heapPos = 0;     //increase when adding new elements, decrease when deleting

    private void heapInc(){
        //increase heap size
        heapSize *= 2;
        heap = Arrays.copyOf(heap, heapSize);
    }

    public void heapAdd(int value){
        //add value
        add(value);
        //keep min heap shape
        heapify();
    }

    private void add(int value){
        //when heap reaches array len, increase heap size
        if(heapPos >= heapSize)
            heapInc();
        //add value to heap, inc heap add Position
        heap[heapPos++] = value;
    }

    private void swap(int index1, int index2){
        //incDecFlag true swaps index element with previous index element
        //incDecFlag false swaps index element with next index element
        int temp;
        temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    private void heapify(){
        for(int i = heapPos-1; i >= 0; i--) {
            //find parent node
            int parentNode = (i-1)/2;

            //swap with parent if parent bigger
            if (heap[parentNode] > heap[i])
                swap(i, parentNode);
        }
    }

    public void printHeap(){
        for(int i = 0; i < heapPos; i++){
            System.out.print(heap[i]+" ");
        }
        System.out.println();
    }

    private int findValue(int value){
        for(int i = 0; i < heapPos-1; i++){
            if(heap[i] == value)
                return i;
        }
        return -1;
    }

    public void deleteValue(int value){
        //find the value in heap
        //replace the value with the last value in heap
        //replace the last value with 0 and dec heapPos
        int valPos = findValue(value);
        if(valPos != -1){
             heap[valPos] = heap[heapPos-1];
             heap[heapPos-1] = 0;
             heapPos--;
        }
        heapify();
    }
}
