package slidingwindow;

public class _438_Find_All_Anagrams_in_a_String {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        int sLen = s.length();
        int pLen = p.length();

        if(sLen < pLen) return res;

        int[] sCount = new int[26];
        int[] pCount = new int[26];

        // 统计 p 和 s 第一个窗口的字符频次
        for(int i = 0; i < pLen; i++){
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }

        if(Arrays.equals(pCount, sCount)) {
            res.add(0);
        }

        // 滑动窗口
        for(int i = pLen; i < sLen; i++){
            sCount[s.charAt(i) - 'a']++;        // 新字符移入窗口
            sCount[s.charAt(i - pLen) - 'a']--; // 旧字符移出窗口

            if(Arrays.equals(pCount, sCount)){ 
                res.add(i - pLen + 1);          // 记录起始索引
            }
        }
        return res;
    }
}