package questions;

import java.util.*;

public class _1_Two_Sum {

    public int[] solution(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int curVal = nums[i];
            int complement = target - curVal;

            if (map.containsKey(complement)){
                return new int[]{i, map.get(complement)};
            }
            map.put(curVal, i);
        }
        return new int[0];
    }

}