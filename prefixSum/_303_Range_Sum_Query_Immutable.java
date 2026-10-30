package prefixSum;

public class _303_Range_Sum_Query_Immutable {
    private int[] preSum;

    public NumArray(int[] nums) {
        // preSum[i] 表示 nums[0...i-1] 的和
        preSum = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++){
            preSum[i+1] = preSum[i] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }
}