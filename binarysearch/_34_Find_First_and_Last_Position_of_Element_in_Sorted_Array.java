package binarysearch;

public class  _34_Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    public int[] searchRange(int[] nums, int target) {
        int first = findBound(nums, target, true);

        if(first == -1) {
            return new int[]{-1, -1};
        }

        int last = findBound(nums, target, false);

        return new int[]{first, last};
    }

    private int findBound(int[] nums, int target, boolean isFirst){
        int left = 0;
        int right = nums.length - 1;
        int bound = -1;

        while(left <= right){
            int mid = left + (right - left)/2;

            if(nums[mid] == target) {
                bound = mid;
                if(isFirst){
                    right = mid - 1; // 继续向左收缩找首位置
                } else {
                    left = mid + 1; // 继续向右收缩找末位置
                }
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return bound;
    }
}