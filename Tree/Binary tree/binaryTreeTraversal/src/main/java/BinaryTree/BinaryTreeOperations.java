package BinaryTree;

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
    public boolean findValue(int value){
        return find(root, value);
    }
    private boolean find(Node node, int value){
        if(node == null)
            return false;
        if(node.value == value)
            return true;

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

}
