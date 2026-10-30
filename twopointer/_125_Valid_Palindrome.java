package twopointer;

public class _125_Valid_Palindrome {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while(left < right){
            // 跳过左边的非字母数字字符
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // 跳过右边的非字母数字字符
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)) ) return false;

            left++;
            right--;
        }
        return true;
    }
}