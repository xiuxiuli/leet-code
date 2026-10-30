package stack;
import java.util.Arrays;

public class _503_Next_Greater_Element_II {
    public int[] nextGreaterElements(int[] nums) {
        //[5, 4, 3, 2, 1]

        int n = nums.length;
        int[] stack = new int[n];
        int top = -1;

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        for (int i = 0; i < n; i++){
            int curVal = nums[i];

            while (top >= 0 && curVal > nums[stack[top]]){
                int preIndex = stack[top--];
                ans[preIndex] = curVal;
            }

            if (i < n){
                stack[++top] = curVal;
            }
        }
    }

    
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        java.util.Arrays.fill(ans, -1);

        int[] stack = new int[n*2]; // 栈里存下标
        int top = -1;

        for (int i = 0; i < n*2; i++){ 
            int curVal = nums[i % n]; // 用取余模拟循环

            // 3. 经典的单调栈：新比旧大就收割
            // 注意：栈里存的是【下标】，对比的是 nums[stack[top]]
            while (top >= 0 && curVal > nums[stack[top]]) {
                int preIndex = stack[top--];
                ans[preIndex] = curVal; // 直接填入答案数组
            }

            // 4. 只在第一圈把下标入栈（第二圈只是为了“救”第一圈没找到答案的人）
            if (i < n){
                stack[++top] = i;
            }
        }
        return ans;
    }
}
}
