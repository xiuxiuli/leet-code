package slidingwindow;

public class _424_Longest_Repeating_Character_Replacement {
    public int characterReplacement(String s, int k) {
        int maxLen = 0;
        int maxCount = 0;

        int[] count = new int[26];

        int left = 0;

        for(int right = 0; right < s.length(); right++){
            int cur = s.charAt(right) - 'A';
            count[cur]++;
            maxCount = Math.max(maxCount, count[cur]);

            while((right - left + 1) - maxCount > k){
                count[s.charAt(left) - 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}