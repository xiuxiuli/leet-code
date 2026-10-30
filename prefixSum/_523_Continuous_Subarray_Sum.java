package prefixSum;

public class _523_Continuous_Subarray_Sum {
     //要找的是“一段连续子数组”的和，而不是“从头开始的前缀和”

    public boolean checkSubarraySum(int[] nums, int k) {
        // key: 前缀和对 k 取模后的余数
        // value: 该余数第一次出现的下标索引
        Map<Integer, Integer> map = new HashMap<>();

        // 初始化：余数为 0 在索引 -1 处，处理从下标 0 开始满足条件的情况
        map.put(0, -1);

        int remainder = 0;

        for(int i = 0; i < nums.length; i++){
            remainder = (remainder + nums[i]) % k;

            //余数相同”，中间夹的那段就一定是 $k$ 的倍数

            if(map.containsKey(remainder)) {
                // 如果当前余数之前出现过，检查区间长度是否至少为 2
                if(i - map.get(remainder) >= 2) {
                    return true;
                } else {
                    // 仅在首次遇到该余数时记录索引，保证能匹配到尽可能长的距离
                    map.put(remainder, i);
                }
            }
        }
        return false;
    }
}