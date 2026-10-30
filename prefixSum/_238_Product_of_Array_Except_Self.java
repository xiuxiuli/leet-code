package prefixSum;

public class _1248_Count_Number_of_Nice_Subarray {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        ans[0] = 1;

        //左*右，避开中间的i

        // 1. 第一遍遍历：计算每个位置左边所有元素的乘积（前缀积）
        for(int i = 1; i < n; i++){
            ans[i] = ans[i-1] * nums[i-1];
        }

        // 2. 第二遍遍历：从右向左动态维护后缀积，并与前缀积相乘
        int suffix = 1;
        for(int i = n -1; i >= 0; i--){
            ans[i] = ans[i] * suffix;    // 当前结果 = 前缀积 * 后缀积
            suffix *= nums[i];   // 更新后缀积，供下一个位置使用
        }

        return ans;
    }
}