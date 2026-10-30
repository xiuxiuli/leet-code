package twopointer;

public class _11_Container_With_Most_Water {
    public int maxArea(int[] height) {
        int maxArea = 0;

        int left = 0; 
        int right = height.length - 1;

        while(left < right){
            int curArea = Math.min(height[left], height[right]) * (right - left);
            
            maxArea = Math.max(curArea, maxArea);
            if(height[left] < height[right]){
                left++;
            } else{
                right--;
            }
        }
        return maxArea;
    }
}