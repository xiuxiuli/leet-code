package 双指针;

public class _283_移动零 {
	public void moveZeroes(int[] nums) {
		if (nums.length == 0) return;
		
		int slow = 0;
		int fast = 0; 
		
		while (fast < nums.length) {
			if (nums[fast] != 0) {
				int temp = nums[slow];
				nums[slow] = nums[fast];
				nums[fast] = nums[slow];
				slow++;
			}
			fast++;
		}
	}
}
