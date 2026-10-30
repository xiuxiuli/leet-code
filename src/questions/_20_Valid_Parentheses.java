package questions;

public class _20_Valid_Parentheses {
    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;

        char[] stack = new char[s.length()];
        int top = -1;

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                top++;
                stack[top] = c;
            } else {
                if (top == -1) return false;
                char left = stack[top-1];
                if (c == ')' &&  left != '(') return false;
                if (c == '}' &&  left != '{') return false;
                if (c == ']' &&  left != '[') return false;
            }
        }
        return top == -1;
    }
}
