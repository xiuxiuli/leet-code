package 双指针;

public class _27_移除元素 {
	public int removeElement(int[] nums, int val) {
		if (nums.length == 0) return 0;
		int slow = 0;
		int fast = 0;
		
		while (fast < nums.length) {
			if (nums[fast] != val) { 
				nums[slow] = nums[fast];
				slow++;
			}
			fast++;
		}
		return slow;
	}
	
//	对撞指针
	public int removeElement1(int[] nums, int val) {
		if (nums.length == 0) return 0;
		int left = 0;
		int right = nums.length - 1;
		
		while (left <= right) {
			if (nums[left] == val) {
				nums[left] = nums[right];
				right--;
			} else {
				left++;
			}
		}
		return right + 1;
	}
}
