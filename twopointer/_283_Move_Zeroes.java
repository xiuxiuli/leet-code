package twopointer;

public class _283_Move_Zeroes {
    public void moveZeroes(int[] nums) {
        int i = 0;

        for(int j = 0; j < nums.length; j++){
            if(nums[j] != 0){ //非零移到前面
                nums[i] = nums[j];
                i++;
            }
        }

        // 2. 将剩余的位置全部补 0
        while(i < nums.length){
            nums[i] = 0;
            i++;
        }
    }
}