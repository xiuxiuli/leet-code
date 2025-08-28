package questions;

import java.util.ArrayList;
import java.util.List;

public class _442_Find_All_Duplicates_in_an_Array{

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1; // 第一步：定位到索引

            if (nums[index] < 0){   // 第二步：检查这个位置是不是负数
                result.add(index + 1);  // 如果负数 → 第2次出现, 重复 → 加入结果
            } else {
                nums[index] = -nums[index]; // 如果不是负数 → 第一次出现 → 打上负号
            }
        }
        return result;
    }

    public static void main(String args[]){
        _442_Find_All_Duplicates_in_an_Array obj = new _442_Find_All_Duplicates_in_an_Array();
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> result = obj.findDuplicates(nums);
        System.out.println(result); 
    }
}