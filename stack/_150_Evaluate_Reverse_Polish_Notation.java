public class _150_Evaluate_Reverse_Polish_Notation {
    public int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length];
        int top = -1;

        for(String token : tokens){
            char firstChar = token.charAt(0);

            if (token.length() == 1 && (firstChar < '0' || firstChar > '9')){
                int b = stack[top--];
                int a = stack[top--];

                switch(firstChar) {
                    case '+': stack[++top] = a + b; break;
                    case '-': stack[++top] = a - b; break;
                    case '*': stack[++top] = a * b; break;
                    case '/': stack[++top] = a / b; break;
                }
            } else {
                stack[++top] = Integer.parseInt(token);
            }
        }
        return stack[top];
    }
}
