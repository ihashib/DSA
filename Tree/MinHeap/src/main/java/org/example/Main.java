package org.example;

import Heap.MinHeap;

public class Main {
    public static void main(String[] args) {
        MinHeap mh = new MinHeap();

        mh.heapAdd(1);
        mh.heapAdd(3);
        mh.heapAdd(4);
        mh.heapAdd(5);
        mh.heapAdd(6);
        mh.heapAdd(7);
        mh.heapAdd(8);
        mh.heapAdd(9);
        mh.heapAdd(10);
        mh.heapAdd(11);

        mh.printHeap();

        mh.heapAdd(2);

        mh.printHeap();

        mh.deleteMin();

        mh.printHeap();

    }
}