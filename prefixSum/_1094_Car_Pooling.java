package prefixSum;

public class _1094_Car_Pooling {
    
    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001];

        for(int[] trip : trips){
            int num = trip[0];
            int from = trip[1];
            int to = trip[2];

            diff[from] += num; // 上车：人数增加
            diff[to] -= num; // 下车：人数减少（在 to 处已经下车了）
        }

        // 2. 从左往右流水模拟当前车上人数 (前缀和)
        int curPassengers = 0;
        for(int i = 0; i <= 1000; i++){
            curPassengers += diff[i];

            // 只要任何时刻超载，直接返回 false
            if(curPassengers > capacity){
                return false;
            }
        }
        return true;
    }
    
}