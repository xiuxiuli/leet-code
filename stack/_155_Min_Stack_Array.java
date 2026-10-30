package stack;

public class _155_Min_Stack_Array {
    private int[] stack;
    private int[] minStack;
    private int top;
    
    public _155_Min_Stack_Array(){
        this.top = -1;
        this.stack = new int[30000];
        this.minStack = new int[30000];
    }

    public void push(int val){
        if (top == -1){
            top++;
            stack[top] = val;
            minStack[top] = val;
        } else {
            int curMin = minStack[top];
            int newMin = Math.min(curMin, val);
            top++;
            stack[top] = val;
            minStack[top] = newMin;
        }
    }

    public void pop(){
        top--;
    }

    public int top(){
        return stack[top];
    }

    public int getMin(){
        return minStack[top];
    }
}
