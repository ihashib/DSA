package DoublyLinkedList;

public class LinkedList {
    Node dummyHead = new Node(0);
    Node tail;

    public void add(int value){
        Node node = new Node(value);

        if(dummyHead.next == null){
            dummyHead.next = node;
            node.prev = dummyHead;
        }
        else{
            tail.next = node;
            node.prev = tail;
        }
        tail = node;

        System.out.println("Value added");
    }

    public void remove(int value){
        Node node = dummyHead.next;
        while(node != null){
            if(node.data == value){
                node.prev.next = node.next;
                node.next.prev = node.prev;

                System.out.println("Value removed");
                break;
            }
            node = node.next;
        }
    }

    public void print(){
        Node node = dummyHead.next;
        while(node != null){
            System.out.print(node.data+" ");
            node = node.next;
        }
        System.out.println();
    }
}
