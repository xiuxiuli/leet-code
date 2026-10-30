pacakge greedy;

public class _55_Jump_Game {
    public boolean canJump(int[] nums) {
        int maxReach = 0; //“截至目前为止，你踩过的所有石头能给你提供的【最大射程】。”

        for(int i = 0; i < nums.length; i++){
            // 如果当前下标超过了能到达的最远距离，说明卡住了，无法继续前进
            if(maxReach < i) return false;

            maxReach = Math.max(maxReach, i + nums[i]);

            if(maxReach >= nums.length - 1) return true;
        }
        return false;
    }
}