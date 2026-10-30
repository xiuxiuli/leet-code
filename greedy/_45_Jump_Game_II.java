package greedy;

public class _45_Jump_Game_II {
    public int jump(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int jumpCount = 0;  // 跳跃次数
        int curEnd = 0;     // 当前跳跃能到达的最远边界
        int nextMax = 0;    // 下一步能到达的最远边界

        for(int i = 0; i < nums.length - 1; i++) { 
            nextMax = Math.max(nextMax, i + nums[i]);

            // 如果来到了当前这一跳的极限边界 //拍平内循环
            if(i == curEnd){
                jumpCount++;
                curEnd = nextMax;   // 更新下一跳的边界

                // 提前剪枝：如果当前边界已经能覆盖终点，直接退出
                if(curEnd >= nums.length - 1) break;
            }
        }
        return jumpCount;
    }
}