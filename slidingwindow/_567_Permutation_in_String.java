package slidingwindow;

public class _567_Permutation_in_String {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        if(len1 > len2) return false;

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for(int i = 0; i < len1; i++){
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        // 检查第一个窗口是否匹配
        if(matches(count1, count2)) return true;

        for(int i = len1; i < len2; i++) {
            count2[s2.charAt(i) - 'a']++;
            count2[s2.charAt(i-len1) - 'a']--;

            if(matches(count1, count2)) return true;
        }
        return false;  
    }

    private boolean matches(int[] count1, int[] count2) {
        for(int i = 0; i < 26; i++){
            if(count1[i] != count2[i]) return false;
        }
        return true;
    }
}