package array;

public class _134_Gas_Station {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;   // 累加整条线路的净油量 (gas - cost)
        int curGas = 0;     // 记录从当前起点 start 开始累积的剩余油量
        int start = 0;      // 记录候选起点

        for(int i = 0; i < gas.length; i++){
            int net = gas[i] - cost[i];
            totalGas += net;
            curGas += net;

            if(curGas < 0){  //i作为起点， 但到了i占后油量变成负数
                start = i + 1;  // i不能作为起点，尝试将下一个站i + 1设为可能的起点
                curGas = 0; 
            }
        }

        if(totalGas < 0) return -1;
        return start;
    }
}