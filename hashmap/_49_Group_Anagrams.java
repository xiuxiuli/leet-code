package hashmap;

public class _49_Group_Anagrams{
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            char[] chars = s.toCharArray();

            Arrays.sort(chars);
            String key = new String(chars);

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams_2(String[] strs) {
        if(strs == null || strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for(String s: strs) {
            char[] count = new char[26];
            for(char c : s.toCharArray()){
                count[c - 'a']++;
            }

            // 直接将 char[26] 转成长度为 26 的 String，避免 StringBuilder 拼接
            String key = new String(count);
            
            map.computeIfAbsent(key, k-> new ArrayList<>()).add(s);

        }

        return new ArrayList<>(map.values());
    }
}