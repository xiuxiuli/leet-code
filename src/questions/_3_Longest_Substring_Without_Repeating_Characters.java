package questions;

import java.util.*;

public class _3_Longest_Substring_Without_Repeating_Characters {
    // falexfs
    // []
    public static int lengthOfLongestSubstring(String s){
        if (s == null || s.length() == 0) return 0;

        // last[c] = 字符 c 上一次出现的位置
        int[] lastSeenAt = new int[128];
        Arrays.fill(lastSeenAt, -1);

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            // System.out.printf("the %d character is: %c, lastSeenAt[%c]=%d, ", right, c, c, lastSeenAt[c]);
            System.out.printf("c=%c, last=%d, left(before)=%d, right=%d, ", c, lastSeenAt[c], left, right);


            if (lastSeenAt[c] >= left){
                left = lastSeenAt[c] + 1;
            }
            // System.out.printf(" [left=%d, right=%d]%n", left, right);
            System.out.printf("left(after)=%d, [left=%d, right=%d], window=%s%n%n", left, left,right, s.substring(left, right + 1));

            lastSeenAt[c] = right;
            maxLen = Math.max(maxLen, right - left + 1);
        }
       
        return maxLen; 

    }

    public static void main(String[] args) { 
        String s = "ababcmkbabf";
        _3_Longest_Substring_Without_Repeating_Characters.lengthOfLongestSubstring(s);
    }
}