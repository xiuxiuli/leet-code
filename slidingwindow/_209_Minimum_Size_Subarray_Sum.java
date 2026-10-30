package slidingwindow;

public class _209_Minimum_Size_Subarray_Sum {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        
        for(int right = 0; right < nums.length; right++){
            sum += nums[right]; // 1. 进窗口：累加右边界元素

            // 2. 满足条件时，尝试收缩左边界以寻找更短的子数组
            while(sum >= target) {
                // 更新结果
                minLen = Math.min(minLen, right - left + 1);

                // 出窗口：减去左边界元素，left右移
                sum -= nums[left];
                left++; 
            }
        }

        // 如果 minLen 未被更新，说明不存在符合条件的子数组，返回 0
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}