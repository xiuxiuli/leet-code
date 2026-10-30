package dp;

public class _213_House_Robber_II {
    public int rob(int[] nums) {
        int n = nums.length;
        if(nums == null || n == 0) return 0;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);

        //case 1: 从 0 偷到 n-2 ； 场景 B：从 1 偷到 n-1
        return Math.max(
            robRange(nums, 0, n - 2 ),
            robRange(nums, 1, n - 1)
        );
    }

    private int robRange(int[] nums, int start, int end){
        if(start == end) return nums[start];

        int p = nums[start];
        int q = Math.max(nums[start], nums[start + 1]);

        for(int i = start + 2; i <= end; i++){
            int cur = Math.max(q, p+nums[i]);
            p = q;
            q = cur;
        }
        return q;
    }
}