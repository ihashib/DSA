package org.example;

import BinaryTree.BinaryTreeOperations;

public class Main {
    public static void main(String[] args) {
        BinaryTreeOperations bto = new BinaryTreeOperations();

        bto.addNode(1);
        bto.addNode(2);
        bto.addNode(3);
        bto.addNode(4);
        bto.addNode(5);

        bto.printPreOrder();
        bto.printInOrder();
        bto.printPostOrder();

        System.out.println("\n"+ bto.findValue(4));
    }
}