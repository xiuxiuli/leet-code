package 双指针;

//Input: nums = [0,0,1,1,1,1,2,3,3]
//Output: 7, nums = [0,0,1,1,2,3,3,_,_]

public class _80_删除有序数组中的重复项_II {
	public int removeDuplicates(int[] nums) {
		if (nums.length <= 2) return nums.length;
		int slow = 2;
		int fast = 2;
		while (fast < nums.length) {
			if (nums[fast] != nums[slow-2]) {
				nums[slow] = nums[fast];
				slow++;
			}
			fast++;
		}
		return slow;
	}
}
