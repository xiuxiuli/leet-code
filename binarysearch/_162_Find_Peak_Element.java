package binarysearch;

public class  _162_Find_Peak_Element {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            int mid = left + (right - left)/2;

            if(nums[mid] < nums[mid + 1]){
                left = mid + 1; // 上坡：峰值在 mid 右侧
            } else {
                right = mid; // 下坡：mid 本身可能是峰值，或峰值在 mid 左侧
            }

        }
        return left; // 最终 left == right，指向一个局部峰值索引
    }
}