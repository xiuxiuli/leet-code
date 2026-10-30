package hashmap;

public class _205_Isomorphic_Strings{
    public boolean isIsomorphic(String s, String t) {
        //记录 s 和 t 中每个字符上一次出现的下标位置（存 i + 1 避免默认值 0 干扰
        int[] lastSeenS = new int[256];
        int[] lastSeenT = new int[256];

        for(int i = 0; i < s.length(); i++) {
            char s1 = s.charAt(i);
            char t1 = t.charAt(i);

            // 如果它们上一次出现的位置不同，说明映射关系冲突
            if(lastSeenS[s1] != lastSeenT[t1]) return false;

            lastSeenS[s1] = i + 1;
            lastSeenT[t1] = i + 1;
        }
        return true;
    }
}