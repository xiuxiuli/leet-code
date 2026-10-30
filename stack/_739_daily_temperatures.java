package stack;

// 单调递增栈
// 栈口值 >= val : 不干事，ANSWER[]
public class _739_daily_temperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] stack = new int[n]; // 存储下标的栈
        int[] answers = new int[n]; //结果数组：还需要等几天

        int top = -1;

        for (int i = 0; i < n; i++){
            int curVal = temperatures[i]; //当前遍历中的值
            int topVal = temperatures[temperatures[top]]; //栈顶数

            while (top >= 0 && curVal > topVal){ //栈不为空，而且当前数>栈顶数，找到了
                int preIndex = stack[top--]; //拿到栈顶的数对应的值，TOP--就是弹出
                answers[preIndex] = i - preIndex;
            }
            stack[++top] = i;
        }
        return answers;
    }
}
