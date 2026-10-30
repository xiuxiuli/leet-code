package dp;

public class _198_House_Robber {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        int p = nums[0]; // 上一步的最优解 dp[i-1]
        int q = Math.max(nums[0], nums[1]); //最后一步的最优解dp[i]

        for(int i = 2; i < nums.length; i++){
            //case 1, get nums[i], cur = p + nums[i];
            //case 2, not get, cur = q;
            int cur = Math.max(q, (p + nums[i]));
            p = q;
            q = cur;
        }
        return q;
    }
}