package 数组;

import java.util.ArrayList;
import java.util.List;

//Given an integer array nums of length n where all the integers of nums are in the range [1, n] 
//Input: nums = [4,3,2,7,8,2,3,1]

public class _442_数组中重复的数据 {
	
	//新建一个数组记录元素出现次数， 用下标代替num
	public List<Integer> findDuplicates(int[] nums) {
		int n = nums.length; //n=8
		
		int[] arr = new int[n]; //arr.length=8
		for (int num : nums) {
			int index =  num;
			arr[index-1]++;
		}
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 2) {
				list.add(i + 1);
			}
		}
		return list;
	}
	
	//不新增空间，在原数组用下标配合负数记录数字出现次数
	// [4, 1 ,3,1,2,7]
	// [4, 1, 3, -1, 2, 7
	public List<Integer> findDuplicates3(int[] nums) {
		List<Integer> list = new ArrayList<>();
		if (nums.length == 0) return list;
		
		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]) - 1;
			if (nums[index] < 0) { //appear once
				list.add(Math.abs(nums[index]));
			} else { //>0, never
				nums[index] *= (-1);
			}
		}
		return list;
	}
}
