package org.example;

import BinaryTree.BinaryTreeOperations;
import BinaryTree.Node;

public class Main {
    public static void main(String[] args) {
        BinaryTreeOperations bto = new BinaryTreeOperations();

        /*
                     5
                    / \
                   2   7
                  / \ / \
                 0  4 6  8
                          \
                           9
         */
        bto.addNode(5); 
        bto.addNode(2);
        bto.addNode(0);
        bto.addNode(4);
        bto.addNode(7);
        bto.addNode(6);
        bto.addNode(8);
        bto.addNode(9);

        bto.printPreOrder();
        bto.printInOrder();
        bto.printPostOrder();

        Node node1 = bto.findValue(0);
        Node node2 = bto.findValue(9);

        System.out.println();
        System.out.println("First common ancestor: "+bto.fca(node1, node2));
    }
}