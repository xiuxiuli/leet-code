package backtracking;

public class _131_Palindrome_Partitioning {
    private List<List<String>> result = new ArrayList<>();
    private List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtrack(s, 0);
        return result;
    }

    private void backtrack(String s, int startIndex) {
        if(startIndex >= s.length()){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = startIndex; i < s.length(); i++){
            if (isPalindrome(s, startIndex, i)) {
                String sub = s.substring(startIndex, i+1);
                path.add(sub);
                backtrack(s, i + 1);
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right){
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}