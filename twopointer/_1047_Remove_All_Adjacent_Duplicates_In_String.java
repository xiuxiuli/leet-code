package twopointer;

public class _1047_Remove_All_Adjacent_Duplicates_In_String {
    public String removeDuplicates(String s) {
        char[] chars = s.toCharArray();

        int i = 0; // i 指向下一个待写入的位置, i - 1 即为“栈顶”

        for(int j = 0; j < chars.length; j++){
            // 如果栈不为空，且“栈顶”字符与当前字符相等
            if(i > 0 && chars[i-1] == chars[j]){
                i--; // 出栈（只需退回指针即可，无需真正清除数据）
            } else {
                chars[i] = chars[j]; //入栈 
                i++;
            }
        }
        return new String(chars, 0, i);
    }
}