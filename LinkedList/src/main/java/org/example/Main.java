package org.example;

import DoublyLinkedList.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.print();

        list.remove(3);
        list.remove(1);

        list.print();
    }
}