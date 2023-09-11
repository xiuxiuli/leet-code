package 数组;

import java.util.ArrayList;
import java.util.List;

//Input: nums = [4,3,2,7,8,2,3,1]
//Output: [5,6]
//加n
public class _448_找到所有数组中消失的数字 {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		int n =  nums.length;
		List<Integer> list = new ArrayList<>();
		if (n == 0) return list;
		
		for (int i = 0; i < n; i++) {
			int index = (nums[i] - 1) % n;
			nums[index] += n;
		}
		
		for (int i = 0; i < n; i++) {
			if (nums[i] <= n) list.add(i + 1);
		}
		return list;
	}
}
