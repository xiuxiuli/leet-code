package 数组;

import java.util.HashMap;
import java.util.Map;

public class _01_下标记录数组 {

	//用map记录数组成员出现的次数
	public void solution(int[] arr) {
		Map<Integer, Integer> countMap = new HashMap<>();
		//num - 数量
		for (int num : arr) {
			if(countMap.containsKey(num)) {
				int count = countMap.get(num);
				countMap.put(num, count++);
			} else { 
				countMap.put(num, 1);
			}
		}
	}
	
	
	
	
	//用下标来记录数组成员 [6, 10, 7, 1, 4, 13]
	public void solution2(int[] arr) {
		int[] newArr = new int[6];
	}
}
