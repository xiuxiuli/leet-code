package 字符串;

public class _1370_上升下降字符串 {
	public String sortString(String s) {
		int[] count = new int[26];
		for (char c : s.toCharArray()) {
			int index = c - 'a';
			count[index]++;
		}
		
		StringBuilder sb = new StringBuilder();

		while (sb.length() < s.length()) {
			for (int i = 0; i < 26; i++) {
				if (count[i] > 0) {
					count[i]--;
					char c = (char)(i + 'a');
					sb.append(c);
				}
			}
			
			for (int k = 25; k >= 0; k--) {
				if (count[k] > 0) {
					count[k]--;
					char c = (char)(k + 'a');
					sb.append(c);
				}
			}
		}
		return sb.toString();
	}
}
