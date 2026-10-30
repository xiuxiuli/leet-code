package stack;

import java.util.*;

public class _496_Next_Greater_Element_I {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] stack = new int[nums2.length];
        int top = -1;

        int[] ans = new int[nums1.length];

        // 先用单调栈跑一遍 nums2, 把结果存进一个 HashMap
        Map<Integer, Integer> map = new HashMap<>();

        //以 [4, 3, 2, 5] 为例
        for (int i = 0; i < nums2.length; i++) {
            int curVal = nums2[i];

            // 当前数大于栈口数， 找到了，记录， 弹出
            while (top >= 0 && curVal > stack[top]){
                map.put(stack[top--], curVal);
            }

            stack[++top] = curVal;
        }

        for(int j = 0; j < nums1.length; j++){
            int key = nums1[j];
            ans[j] = map.getOrDefault(key, -1);
        }
        return ans;
    }
}
