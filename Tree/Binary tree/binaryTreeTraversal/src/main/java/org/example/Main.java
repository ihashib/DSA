package org.example;

import java.util.List;

import BinaryTree.BinaryTreeOperations;
import BinaryTree.Node;

public class Main {
    public static void main(String[] args) {
        System.out.println("START BST0 ====================");
        BinaryTreeOperations bst0 = new BinaryTreeOperations();

        // 1 2 3 4 5 6 7 8 9 10 11 12
        bst0.addNode(6);
        bst0.addNode(3);
        bst0.addNode(9);
        bst0.addNode(7);
        bst0.addNode(8);
        bst0.addNode(11);
        bst0.addNode(10);
        bst0.addNode(12);
        bst0.addNode(1);
        bst0.addNode(2);
        bst0.addNode(4);
        bst0.addNode(5);

        System.out.println("BST root: "+bst0.getRoot().value);

        bst0.printPreOrder();
        bst0.printInOrder();
        bst0.printPostOrder();

        Node node1 = bst0.findValue(2);
        Node node2 = bst0.findValue(5);

        System.out.println();
        System.out.println("First common ancestor: "+bst0.getFirstCommonAncestor(node1, node2));

        System.out.println("END BST1 ==============");

        System.out.println("START BST1 ====================");

        BinaryTreeOperations bst1 = new BinaryTreeOperations();
        int[] bstArray = new int[] {1,2,3,4,5,6,7,8,9,10,11,12};

        bst1.buildMinimalBst(bstArray);

        bst1.printInOrder();
        bst1.printPreOrder();

        Node bst1Root = bst1.getRoot();
        System.out.println("\nBST Root: "+bst1Root.value);

        List<List<Integer>> list = bst1.generateAllBstList(bst1Root);

        System.out.println("BST Sequence");
        System.out.println(list);
    }
}