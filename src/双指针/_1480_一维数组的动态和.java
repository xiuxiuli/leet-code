package 双指针;

public class _1480_一维数组的动态和 {
	public int[] runningSum(int[] nums) {
		int[] result = new int[nums.length];
		result[0] = nums[0];
		
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			result[j] = result[i] + nums[j];
			i++;
		}
		return result;
	}
}
