package prefixSum;

public class _930_Binary_Subarrays_With_Sum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int[] count = new int[nums.length + 1];
        count[0] = 1; // 初始化：前缀和为 0 出现 1 次

        int curSum = 0;
        int ans = 0;

        for(int num : nums){
            curSum += num;

            int target = curSum - goal;
            if(target >= 0){
                ans += count[target];
            }

            count[curSum]++;
        }
        return ans;
    }
}