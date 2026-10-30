package stack;

import java.util.*;

public class _155_Min_Stack {

    private class Node {
        private int value;
        private int curMin;

        public Node(int value, int curMin){
            this.value = value;
            this.curMin = curMin;
        }
    }

    private List<Node> stack;

    // constructor
    public _155_Min_Stack() {
        this.stack = new ArrayList<>();
    }

    public void push(int val){
        int min;
        if(stack.isEmpty()) {
            min = val;
        } else {
            min = Math.min(val, stack.get(stack.size() - 1).curMin);
        } 
        Node newNode = new Node(val, min);
        stack.add(newNode);
    }

    public void pop(){
        stack.remove(stack.size() - 1);

    }

    public int top(){
        return stack.get(stack.size() - 1).value;
    }

    public int getMin() {
        return stack.get(stack.size()-1).curMin;
    }
    
}