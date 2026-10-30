package twopointer;

public class _15_3Sum{
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 3) return res;

        // 1. 排序
        Arrays.sort(nums);

        int n = nums.length;

        //固定外层(指针 i)：遍历数组作为第一个数nums[i]，将问题转换为求后方区域内nums[left] + nums[right] = -nums[i]的 2Sum 问题。

        for(int i = 0; i < n - 2; i++){
            // 剪枝优化：若当前最小的数大于0，后续三数之和不可能为0
            if(nums[i] > 0) break;

            // 关键去重 1：固定数 nums[i] 去重
            if(i > 0 && nums[i-1] == nums[i]) continue;

            // 2. 转换为 2Sum 对撞指针问题
            int left = i + 1;
            int right = n - 1;
            int target = -nums[i];

            while(left < right){
                int sum = nums[left] + nums[right];

                if(sum == target){
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 关键去重 2：内层对撞指针去重
                    while(left < right && nums[left] == nums[left+1]) left++;
                    while(left < right && nums[right] == nums[right-1]) right--;

                    // 找到可行解后，两侧同时向内移动
                    left++;
                    right--;
                } else if(sum < target) {
                    left++;
                } else{
                    right--;
                }
            }
        }
        return res;
    }
}