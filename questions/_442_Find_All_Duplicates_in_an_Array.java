package questions;

import java.util.ArrayList;
import java.util.List;

public class _442_Find_All_Duplicates_in_an_Array{

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++){
            if (nums[i] < 0){
                result.add(i);
            } else {
                int index = nums[i]-1;
                nums[index] = nums[index] * -1;
            }
        }
        return result;
    }

    public static void main(String args[]){
        _442_Find_All_Duplicates_in_an_Array obj = new _442_Find_All_Duplicates_in_an_Array();
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> result = obj.findDuplicates(nums);
    }
}