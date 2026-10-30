package binarysearch;

public class _704_Binary_Search {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // [left, right]

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}