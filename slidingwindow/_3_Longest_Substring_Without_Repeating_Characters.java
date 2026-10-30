package slidingwindow;

public class _3_Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        // Set<Character> set = new HashSet<>();

        // 用数组代替 HashSet，ASCII 码一共 128 个字符
        // lastPos[c] 记录字符 c 上一次出现的索引位置（初始化为 -1）
        int[] lastPos = new int[128];
        Arrays.fill(lastPos, -1);

        int left = 0;
        int maxLen = 0;

        for(int right = 0; right < s.length(); right++) {
            char cur = s.charAt(right);

            // 如果 cur 之前出现过，直接将 left 跳到它上次出现位置的下一位
            if(lastPos[cur] != -1) {
                left = Math.max(left, lastPos[cur] + 1);
            }

            // 更新字符 cur 的最新位置
            lastPos[cur] = right;

            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}