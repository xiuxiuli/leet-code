package 双指针;

public class _11_盛最多水的容器 {
	
	//暴力解法
	public int maxArea(int[] height) {
		if (height.length == 1) return -1;
		int maxArea = 0;
		for (int i = 0; i < height.length; i++) {
			for (int j = i + 1; j < height.length; j++) {
				int w = j - i;
				int h = Math.min(height[i], height[j]);
				int area = w * h;
				maxArea = Math.max(maxArea, area);
			}
		}
		return maxArea;
	}
	
	//对撞指针	
	public int maxArea2(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int maxArea = 0;
		
		while (left < right) {
			int area = Math.min(height[left], height[right]) * (right- left);
			maxArea = Math.max(maxArea, area);
			
			if (height[left] < height[right]) left++;
			else right--;
		}
		return maxArea;
	}
}
