package twopointer;

public class _153_Find_Minimum_in_Rotated_Sorted_Array {
    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            int mid =left + (right -left) / 2;

            if (nums[mid] <= nums[right]){
                right = mid; // 最小值在 mid 或 mid 左边
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}