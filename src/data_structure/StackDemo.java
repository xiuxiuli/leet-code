package data_structure;

import java.util.Stack;

public class StackDemo {

    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        System.out.println("The stack is originally empty: " + stack.isEmpty());
        stack.push(5);
        stack.push(13);
        stack.push(9);
        stack.push(11);
        stack.pop();
        System.out.println("The top of the stack is: " + stack.peek());
        stack.pop();
        System.out.println("Pop one, then the top of the stack is: " + stack.peek());
        System.out.println("Now the full stack is: " + stack);
    }
}