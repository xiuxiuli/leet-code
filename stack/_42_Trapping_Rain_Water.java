

//单调栈， 双指针， 动态规划
public class _42_Trapping_Rain_Water {
    public int trap(int[] height) {
        int n = height.length;
        int[] newHeight = new int[n + 2];

        // COPY，前后加守卫
        for(int i = 0; i < n; i++){
            newHeight[i + 1] = height[i];
        }

        //单调递减栈，栈底数(做凹槽的左边)大， 栈头数（做凹槽的中间）小
        int[] stack = new int[n + 2];
        int top = -1;

        int area = 0;

        for(int j = 0; j < newHeight.length; j++){ // J是凹槽的右边
            int cur = newHeight[j];

            // 单调递减栈
            while(top != -1 && cur > newHeight[stack[top]] ){
                int midIndex = stack[top--];

                if(top == -1) break;

                int left = stack[top];
                int right = j; 

                int h = Math.min(newHeight[left], newHeight[right]) - newHeight[midIndex];
                int w = right - left - 1;

                area += h * w;
            }
            stack[++top] = j;
        }
        return area;
    }
}
