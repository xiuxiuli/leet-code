package 双指针;

public class _26_删除有序数组中的重复项 {
	public int removeDuplicates(int[] nums) {
		int slow = 0;
		for (int fast = 1; fast < nums.length; fast++) {
			while (nums[slow] != nums[fast]) {
				slow++;
				nums[slow] = nums[fast];
			}
		}
		return slow + 1;
	}
}