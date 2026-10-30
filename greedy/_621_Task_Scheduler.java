package greedy;

public class _621_Task_Scheduler {
    public int leastInterval(char[] tasks, int n) {
        // 1. 统计每个任务（字母）出现的次数
        int[] freq = new int[26];

        for(char task : tasks){
            freq[task - 'A']++;
        }

        // 2. 找出最高频任务的频次 maxExec
        int maxExec = 0;
        for(int count : freq) {
            maxExec = Math.max(count, maxExec);
        }

        // 3. 统计有多少个任务同样达到了最高频次 maxExec
        int maxCount = 0;
        for (int count : freq){
            if(count == maxExec) maxCount++;
        }

        // 4. 根据桶思想计算理论最小耗时
        int partCount = maxExec - 1;    // 形成的桶间隔数量
        int partLength = n + 1;     // 每个桶（包含任务本身和冷却区）的长度
        int minTime = partCount * partLength + maxCount; 
        // 前面所有完整桶所占时间 + 最后一桶里放的最高频任务个数

        // 如果其他任务能把这些空位置填满（甚至填爆），说明根本不需要 idle，最少时间就是任务的总数量 tasks.length。
        return Math.max(tasks.length, minTime);
    }
}