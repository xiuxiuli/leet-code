package 双指针;

public class _344_反转字符串 {
	public void reverseString(char[] s) {
		 int left = 0;
		 int right = s.length - 1;
		 while (left <= right) {
			 char c = s[right];
			 s[right] = s[left];
			 s[left] = c;
			 left++;
			 right--;
		 }
	}
}
