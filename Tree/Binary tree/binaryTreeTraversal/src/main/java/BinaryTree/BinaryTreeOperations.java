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
        /*
        * Find the 2 node's shortest paths from root using bfs
        * Keep the paths, compare both and find the last same nodes from both node's paths
        * The last same node is the first common ancestor
        * Example:
        * Node 1 path: 1 2 5 6 7
        * Node 2 path: 1 2 5 0 9
        * So here the FCA is node 5
        * Note: fca -1 means there's no fca
        */
        int fca = -1;
        List<Integer> node1Path;
        List<Integer> node2Path;

        node1Path = shortestPathFromRoot(node1);
        node2Path = shortestPathFromRoot(node2);

        int minPathSize = Math.min(node1Path.size(), node2Path.size());

        for(int i = 0; i < minPathSize; i++){
            if(node1Path.get(i) == node2Path.get(i))
                fca = node1Path.get(i);
            else    
                break;
        }

        return fca;
    }
    private List<Integer> shortestPathFromRoot(Node node){
        List<Integer> path = new ArrayList<>();
        HashMap<Node, Node> parent = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        q.offer(root);
        parent.put(root, null);

        while(!q.isEmpty()){
            Node current = q.remove();

            if(node.value == current.value){
                // Backtrack to parent and add to path
                while(current != null){
                    path.add(0, current.value);
                    current = parent.get(current);
                }
                return path;
            }

            if(current.left != null){
                q.offer(current.left);

                // keep parent info of the child node
                parent.put(current.left, current);
            }
            if(current.right != null){
                q.offer(current.right);

                // keep parent info of the child node
                parent.put(current.right, current);
            }
        }

        return path;
    }
    

}
