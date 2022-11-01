package DoublyLinkedList;

public class Node {
    public Node next;
    public Node prev;
    public int data;

    public Node(int data){
        this.data = data;
        next = null;
        prev = null;
    }
}
