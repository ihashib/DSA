package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeOperations {
    Node root;
    //insert
    public void addNode(int value){
        //start from root
        root = recursiveAdd(root, value);
    }
    private Node recursiveAdd(Node current, int value){
        /*
            if the new node's value is lower than the current node's, we go to the left child
            if the new node's value is greater than the current node's, we go to the right child
            when the current node is null, we've reached a leaf node and we can insert the new node in that position
         */
        if(current == null){
            System.out.println("Inserting: "+ value);
            return new Node(value);
        }

        if(current.value > value){
            current.left = recursiveAdd(current.left, value);
        }
        if(current.value < value){
            current.right = recursiveAdd(current.right, value);
        }
        else{
            System.out.println("Value already exists");
        }
        //if value already exists
        return current;
    }

    //find
    public Node findValue(int value){
        return find(root, value);
    }
    private Node find(Node node, int value){
        if(node == null)
            return null;
        if(node.value == value)
            return node;

        return node.value > value?find(node.left, value):find(node.right, value);
    }

    //print pre order
    public void printPreOrder(){
        System.out.println("\nPre order: ");
        prePrint(root);
    }
    private void prePrint(Node node){
        //Root > Left > Right
        if(node == null){
            return;
        }

        System.out.print(node.value+" ");

        prePrint(node.left);

        prePrint(node.right);
    }
    //print in order
    public void printInOrder(){
        System.out.println("\nIn Order: ");
        inPrint(root);
    }
    private void inPrint(Node node){
        //Left > Root > Right
        if(node == null){
            return;
        }

        inPrint(node.left);

        System.out.print(node.value+" ");

        inPrint(node.right);
    }
    //print post order
    public void printPostOrder(){
        System.out.println("\nPost Order: ");
        postPrint(root);
    }
    private void postPrint(Node node){
        //Left > right > root
        if(node == null){
            return;
        }

        postPrint(node.left);

        postPrint(node.right);

        System.out.print(node.value+" ");
    }

    // First common ancestor / Least common ancestor
    public int fca(Node node1, Node node2){
        int fcaNode = -1;

        List<Integer> path1 = bfsSearch(node1);
        List<Integer> path2 = bfsSearch(node2);

        System.out.println("Node 1 path: "+path1);
        System.out.println("Node 2 path: "+path2);

        int minPathSize = Math.min(path1.size(), path2.size());

        for(int i = 0; i < minPathSize; i++){
            if(path1.get(i) == path2.get(i)){
                fcaNode = path1.get(i);
            }
        }

        return fcaNode;
    }
    // Helper bfs method
    public List<Integer> bfsSearch(Node nodeToFind){
        HashMap<Node, Node> parent = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        List<Integer> path = new ArrayList<>();

        q.add(root);
        parent.put(root, null);

        while(!q.isEmpty()){
            Node node = q.remove();

            if(nodeToFind.value == node.value){
                while(node != null){
                    path.add(0, node.value);
                    node = parent.get(node);
                }
                return path;
            }

            if(node.left != null){
                q.add(node.left);
                parent.put(node.left, node);
            }
            if(node.right != null){
                q.add(node.right); 
                parent.put(node.right, node);  
            }
        }

        return path;
    }

}
