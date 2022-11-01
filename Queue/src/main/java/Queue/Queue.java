package Queue;

import java.util.LinkedList;

public class Queue {
    private LinkedList<Integer> list = new LinkedList<>();

    public void enqueue(int value){
        list.add(value);
    }

    public int dequeue(){
        if(list.isEmpty())
            return -1;

        int val = list.getFirst();
        list.removeFirst();

        return val;
    }

    public int peek(){
        if(list.isEmpty())
            return -1;

        return list.getFirst();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }
}
