package backtracking;

public class _17_Letter_Combinations_of_a_Phone_Number {
    private List<String> result = new ArrayList<>();
    private StringBuilder path = new StringBuilder();

    private String[] letterMap = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    //"23"
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) return result;

        backtrack(digits, 0);
        return result;
    }

    // ("23", 0)
    private void backtrack(String digits, int index){
        // 1. 终止条件：当遍历到 digits 结尾时，保存结果并返回
        if(index == digits.length()){
            result.add(path.toString());
            return;
        }

        //"2" -> "abc"
        // 2. 获取当前数字对应的字母字符串
        int digit = digits.charAt(index) - '0';
        String letters = letterMap[digit];

        // 3. 遍历当前字母字符串中的每一个字符
        for(int i = 0; i < letters.length(); i++){
            path.append(letters.charAt(i));     // 做选择
            backtrack(digits, index + 1);       // 递归：处理下一个数字
            path.deleteCharAt(path.length()-1); // 撤销选择（恢复现场）
        }
    }
}