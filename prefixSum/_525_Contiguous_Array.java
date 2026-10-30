package prefixSum;

public class _525_Contiguous_Array {
    public int findMaxLength(int[] nums) {
        // 哈希表：key = 前缀和, value = 该前缀和第一次出现的索引下标
        Map<Integer, Integer> map = new HashMap<>();

        // 初始化：前缀和为 0 在索引 -1 处出现，用于处理从下标 0 开始满足条件的情况
        map.put(0, -1);

        int preSum = 0;
        int maxLen = 0;

        for(int i = 0; i < nums.length; i++){
            // 将 1 视为 +1，0 视为 -1
            preSum += (nums[i] == 1) ? 1 : -1;

            if(map.containsKey(preSum)) {
                // 如果当前前缀和之前出现过，说明两次出现之间的子数组和为 0
                maxLen = Math.max(maxLen, i - map.get(preSum));
            } else {
                // 仅在首次遇到该前缀和时记录索引，以保证计算的子数组长度最大
                map.put(preSum, i);
            }
        }
        return maxLen;
    }
}