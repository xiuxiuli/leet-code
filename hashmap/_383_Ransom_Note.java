package hashmap;

public class _383_Ransom_Note{
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()) return false;

        int[] count = new int[26];

        for(char c : magazine.toCharArray()){
            count[c - 'a']++;
        }

        for(char c : ransomNote.toCharArray()){
            count[c - 'a']--;

            if(count[c - 'a'] < 0) return false;
        }
        return true;
    }
}