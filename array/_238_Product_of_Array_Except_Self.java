package array;

public class _238_Product_of_Array_Except_Self {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        res[0] = 1;

        //左*右，避开中间的i

        // 1. 第一遍遍历：计算每个位置左边所有元素的乘积（前缀积）
        for(int i = 1; i < n; i++){
            res[i] = res[i-1] * nums[i-1];
        }

        // 2. 第二遍遍历：计算每个位置右边所有元素的乘积（后缀积），并直接乘入res
        int right = 1;
        for(int i = n -1; i >= 0; i--){
            res[i] = res[i] * right;    // 当前结果 = 前缀积 * 后缀积
            right *= nums[i];   // 更新后缀积，供下一个位置使用
        }

        return res;
    }
}