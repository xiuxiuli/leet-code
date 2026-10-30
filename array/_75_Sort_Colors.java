package array;

public class _75_Sort_Colors {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int cur = 0;

        while(cur <= right) {
            if(nums[cur] == 0){
                swap(nums, left, cur);
                left++;
                cur++;
            } else if(nums[cur] == 2) {
                swap(nums, right, cur);
                right--;
            } else {
                cur++;
            }
        }

    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}