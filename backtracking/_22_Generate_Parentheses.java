package backtracking;

public class _22_Generate_Parentheses {
    private List<String> result = new ArrayList<>();
    private StringBuilder path = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        backtrack(n, 0, 0);
        return result;
    }

    private void backtrack(int n, int open, int close){
        if(path.length() == n * 2) {
            result.add(path.toString());
            return;
        }

        // 选择 1：尝试添加左括号 '('
        if(open < n) {
            path.append('(');
            backtrack(n, open + 1, close);
            path.deleteCharAt(path.length() - 1);   // 撤销选择（回溯）
        }

        // 选择 2：尝试添加右括号 ')'
        if(close < open){
            path.append(')');
            backtrack(n, open, close + 1);
            path.deleteCharAt(path.length() -1);
        }
    }
}