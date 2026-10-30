package prefixSum;

public class _1248_Count_Number_of_Nice_Subarray {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        
        int[] count = new int[n+1]; //count[s] 表示前缀奇数个数为 s 的前缀出现过多少次
        count[0] = 1; // 基础情况：前缀和为 0 出现 1 次

        int ans = 0;
        int curSum = 0;

        for(int num : nums){
            curSum += (num & 1); // 如果是奇数加 1，偶数加 0

            int target = curSum - k; // 查找前面有多少个前缀的奇数个数为 curSum - k
            if(target >= 0){
                ans += count[target];
            }

            count[curSum]++;
        }
        return ans;
    }
}