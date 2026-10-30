package questions;

import java.util.*;

public class _560_Subarray_Sum_Equals_K {
    public int subarraySum(int[] nums, int k) {
        //[0,1,.....i....j....]
        //sum[i, j] = k - sum[0, i]
        //

        if (nums == null || nums.length == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); //

        int count = 0;
        int curSum = 0; //[0~j]的和

        for (int j = 0; j < nums.length; j++){
            curSum += nums[j];
            int preSum = curSum - k; //preSum, [0, i]的和

            if (map.containsKey(preSum)){
                count += map.get(preSum);
            }
            
            map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        }
        return count;
    }
}
