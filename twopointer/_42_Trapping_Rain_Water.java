package twopointer;

public class _42_Trapping_Rain_Water {
    public int trap(int[] height) {
        if(height == null || height.length < 3) return 0;

        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;

        int area = 0;

        while(left < right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            //短板决定上限
            if(leftMax < rightMax){
                area += leftMax - height[left];
                left++;
            } else {
                area += rightMax - height[right];
                right--;
            }
        }
        return area;
    }
}