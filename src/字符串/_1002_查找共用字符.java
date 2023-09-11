package 字符串;

import java.util.ArrayList;
import java.util.List;

public class _1002_查找共用字符 {
	
	public List<String> commonChars(String[] words) {
		List<String> list = new ArrayList<>();
		
		int[] minFreq =  new int[26];
		String str1 =  words[0];
		for (char c : str1.toCharArray()) {
			int index =  c - 'a';
			minFreq[index]++;
		}
		
		for (int i = 1; i < words.length; i++) {
			int[] count = new int[26];
			String str =  words[i];
			for (char c : str.toCharArray()) {
				int index = c - 'a';
				count[index]++;
			}  
			
			for(int j = 0; j < 26; j++) {
				minFreq[j] = Math.min(minFreq[j], count[j]);
			}
		}
		
		for (int i = 0; i < 26; i++) {
			for (int k = 0; k < minFreq[i]; k++) {
				list.add(String.valueOf((char)(i + 'a')));
			}
		}		
		return list;
	}
}
