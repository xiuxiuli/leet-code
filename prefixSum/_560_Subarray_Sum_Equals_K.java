package prefixSum;

public class _560_Subarray_Sum_Equals_K {
     public int subarraySum(int[] nums, int k) {
        // key: 前缀和, value: 该前缀和出现的次数
        Map<Integer, Integer> preSum = new HashMap<>();

        // 初始化：前缀和为 0 出现 1 次（覆盖 nums[0..i] 的和本身就等于 k 的情况）
        preSum.put(0, 1);

        int curSum = 0;
        int count = 0;

        for(int num : nums){
            curSum += num;

            // 如果存在前缀和 target = currentSum - k，累加其出现的次数
            int target = curSum - k;
            if(preSum.containsKey(target)) {
                count += preSum.get(target);
            }

            // 记录当前前缀和出现的次数
            preSum.put(curSum, preSum.getOrDefault(curSum, 0) + 1);
        }

        return count;
    }
}