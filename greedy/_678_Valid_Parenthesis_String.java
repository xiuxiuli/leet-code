package greedy;

public class _678_Valid_Parenthesis_String {
    public boolean checkValidString(String s) {
        int minLeftCount = 0;    // 最少可能剩下几个【未匹配】的(,（即尽量把*假设为右括号)时 ）
        int maxLeftCount= 0;    // 最多可能剩下的几个【未匹配】的(,（即尽量把 * 假设为左括号(时）

        for(char c : s.toCharArray()){
            if(c == '(') {
                minLeftCount++;
                maxLeftCount++;
            } else if(c == ')') {
                minLeftCount--;
                maxLeftCount--;
            } else {    // '*'
                minLeftCount--;     //如果把*当成)， 那么未匹配的(就少一个了
                maxLeftCount++;     //如果把*当成(， 那么未匹配的(就多一个了
            }

            // 如果上界都小于 0，说明即便把所有的 '*' 全部当做 '('，右括号还是太多了
            if(maxLeftCount < 0) return false;

            // 未匹配的左括号数量不能为负数（最多只能清零）
            if(minLeftCount < 0) minLeftCount = 0;
        }
        return minLeftCount == 0;
    }
}
