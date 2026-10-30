package dp;

public class _300_Longest_Increasing_Subsequence {
    //不要求连续
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int[] dp = new int[n]; //dp[i] 存的是“以第i个元素 nums[i] 作为结尾”的最长递增子序列的长度
        Arrays.fill(dp, 1);

        int maxLen = 1; // 记录全局最大长度

        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}