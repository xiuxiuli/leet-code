package prefixSum;

public class _974_Subarray_Sums_Divisible_by_K {
    //一定要区分“前缀和”和“子数组
    //余数相同的两个【前缀和】，它们相减得到的子数组可以整除K
    public int subarraysDivByK(int[] nums, int k) {
        int[] count = new int[k]; //记录的是前缀和模 k 的余数频次
        count[0] = 1;   // 虚拟前缀和 prefix[ -1 ] = 0，余数为 0 出现 1 次

        int prefixSum = 0;
        int ans = 0;

        for(int num : nums){
            prefixSum += num;

            int remainder = (prefixSum % k + k) % k;

            ans += count[remainder];

            count[remainder]++;
        }
        return ans;
    }
}