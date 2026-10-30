package questions;

public class _209_Minimum_Size_Subarray_Sum {
    public int minSubArrayLen(int[] nums, int target){
        int minLen = Integer.MAX_VALUE;

        int left = 0;
        int sum = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target){
                minLen = Math.min(minLen, right - left + 1);

                sum -= nums[left];
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}