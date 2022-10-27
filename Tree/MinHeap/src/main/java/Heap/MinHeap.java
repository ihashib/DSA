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

    private void buildMinHeap(){
        int left, right;
        for(int i = 0; i < heapPos-1; i++) {
            left = 2*i + 1;
            right = 2*i + 2;

            if(heap[left] == 0 || heap[right] == 0)
                break;

            if(heap[i] > heap[left])
                swap(i, left);
            else if(heap[i] > heap[right])
                swap(i, right);
        }
        heapify();
    }

    public void printHeap(){
        for(int i = 0; i < heapPos; i++){
            System.out.print(heap[i]+" ");
        }
        System.out.println();
    }

    public int findValue(int value){
        for(int i = 0; i < heapPos-1; i++){
            if(heap[i] == value)
                return i;
        }
        return -1;
    }

    public void deleteMin(){
        heap[0] = heap[heapPos-1];
        heap[heapPos-1] = 0;
        --heapPos;
        buildMinHeap();
    }
}
