package questions;

public class _76_Minimum_Window_Substring {
    public static String minWindow(String s, String t){
        int[] tNeed = new int[128];
        for (char c : t.toCharArray()) tNeed[c]++;

        int tRequireSize = 0;
        for (int i = 0; i < tNeed.length; i++){
            if (tNeed[1] > 0) tRequireSize++;
        }

        int[] subStringHave = new int[128];

        int valid = 0; //
        
        int start = 0;

        int minLen = Integer.MAX_VALUE;

        int left = 0, right = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            if (tNeed[c] > 0) {
                subStringHave[c]++;
                if (subStringHave[c] == tNeed[c]) valid++;
            }

            while (valid == tRequireSize) {
                if (right - left < minLen) {
                    minLen = right - left;
                    start =  left;
                }

                char d = s.charAt(left);
                left++;

                if (tNeed[d] > 0){
                    if (subStringHave[d] == tNeed[d]){
                        valid--;
                    }
                    subStringHave[d]--;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}