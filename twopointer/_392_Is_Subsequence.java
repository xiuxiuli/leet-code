package twopointer;

public class _392_Is_Subsequence {
    //Subsequence（子序列）本来就不要求连续
    public boolean isSubsequence(String s, String t) {
        int i = 0; // s 的指针
        int j = 0; // t 的指针

        // 遍历 t，尝试匹配 s 中的字符
        while(i < s.length() && j < t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++; // 匹配成功，s 指针前进
            }
            j++; // 无论是否匹配，t 指针都要无脑向前走
        }
        return i == s.length();
    }
}