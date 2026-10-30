package twopointer;

public class _26_Remove_Duplicates_from_Sorted_Array {
    public int removeDuplicates(int[] nums) {
        int i = 0;

        // [1, 2, 2, 2, 3, 5 ,5]
        //        i     j
        //它根本不去“找重复元素并删除”，而是只“寻找新元素并收集”！
        for(int j = 0; j < nums.length; j++){
            if(i == 0 || nums[i-1] != nums[j]){
                nums[i] = nums[j];
                i++;
            }
        }
    }
}