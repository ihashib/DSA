package org.example;

import java.util.List;

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
        // 1 2 3 4 5 6 7 8 9 10 11 12
        // 1 2   4 5   7 8  10 11 12 
        bto.addNode(6);
        bto.addNode(3);
        bto.addNode(9);
        bto.addNode(7);
        bto.addNode(8);
        bto.addNode(11);
        bto.addNode(10);
        bto.addNode(12);
        bto.addNode(1);
        bto.addNode(2);
        bto.addNode(4);
        bto.addNode(5);

        System.out.println("BST root: "+bto.getRoot().value);

        bto.printPreOrder();
        bto.printInOrder();
        bto.printPostOrder();

        Node node1 = bto.findValue(2);
        Node node2 = bto.findValue(5);

        System.out.println();
        System.out.println("First common ancestor: "+bto.fca(node1, node2));

        System.out.println("START BTO1 ====================");

        BinaryTreeOperations bto1 = new BinaryTreeOperations();

        /*
                     5
                    / \
                   2   7
                  / \ / \
                 0  4 6  8
                          \
                           9
         */
        int[] bstArray = new int[] {1,2,3,4,5,6,7,8,9,10,11,12};
        bto1.buildMinimalBst(bstArray);

        

        bto1.printInOrder();
        bto1.printPreOrder();

        

        // Node root = bto1.getRoot();
        // System.out.println("BST Root: "+root.value);

        // List<List<Integer>> list = bto1.weaveSubtrees(root);

        // System.out.println("BST Sequence");
        // System.out.println(list);
    }
}