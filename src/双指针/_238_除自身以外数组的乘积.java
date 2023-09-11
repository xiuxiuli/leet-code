package 双指针;

public class _238_除自身以外数组的乘积 {
	public int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		
		int[] leftProduct= new int[n];
		leftProduct[0] = 1;
		for (int i = 1; i < n; i++) {
			leftProduct[i] = leftProduct[i - 1] * nums[i - 1];
		}
		
		int[] rightProduct = new int[n];
		rightProduct[n - 1] = 1;
		for (int j = n - 2; j >= 0; j--) {
			rightProduct[j] = rightProduct[j + 1] * nums[j + 1];
		}
		
		int[] result = new int[n];
		for (int k = 0; k < n; k++) {
			result[k] = leftProduct[k] * rightProduct[k];
		}
		return result;
	}
	
	//上面的解法开辟了三个数组空间，现在进行空间优化
	public int[] productExceptSelf2(int[] nums) {
		int n = nums.length;
		
		//只开辟一个数组，它先存放左边的乘积
		int[] result = new int[n];
		result[0] = 1;
		for (int i = 1; i < n; i++) { //存入左边的乘积
			result[i] = result[i - 1] * nums[i - 1];
		}
		
		int rightProduct = 1; //用变量在存放右边的乘积
		for (int j = n - 1; j >= 0; j--) { //从后往前
			result[j] = result[j] * rightProduct; //左乘积 * 右乘积， 存入答案
			rightProduct = rightProduct * nums[j];//更新下一个右乘积
		}
		return result;
	}
}
