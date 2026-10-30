package hashmap;

public class _128_Longest_Consecutive_Sequence {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }
        
        int maxLen = 0;

        for (int num : set){
            if(!set.contains(num-1)){
                int curNum = num;
                int curLen = 1;

                while(set.contains(curNum + 1)) {
                    curNum++;
                    curLen++;
                }

                maxLen = Math.max(maxLen, curLen);
            }
        }
        return maxLen;
    }
}