package Stack;

import java.util.LinkedList;

public class Stack {
    private LinkedList<Integer> list = new LinkedList<>();

    public void push(int value){
        list.addLast(value);
    }

    public int pop(){
        if(list.isEmpty())
            return -1;

        int val = list.getLast();
        list.removeLast();

        return val;
    }

    public int peek(){
        if(list.isEmpty())
            return -1;

        return list.getLast();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }
}
