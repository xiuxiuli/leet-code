package twopointer;

public class _80_Remove_Duplicates_from_Sorted_Array_II {
    public int removeDuplicates(int[] nums) {
        int i = 0;

        // i是待填坑位， 对比之前已经整理好的，填好后I向前， J一直无脑向前
        for(int j = 0; j < nums.length; j++){
            if(i < 2 || nums[i - 2] != nums[j]){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}