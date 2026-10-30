public class _907_Sum_of_Subarray_Minimums {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long totalSum = 0;
        int MOD = 1_000_000_007;

        //为了方便处理边界，我们在最后“虚拟”一个非常小的数（哨兵）
        int[] stack = new int[n + 1]; //index 
        int top = -1;

        for (int i = 0; i <= n; i++){
            int cur = (i == n) ? -1 : arr[i];

            //破坏了递增， 找到右边有更小的数， 
            while(top != -1 && cur < arr[stack[top]]) {
                int mid = stack[top--]; //弹出主角（我们要算它贡献了多少次）

                // 此时的栈顶是左边第一个比它小的数
                int leftBound = (top == -1) ? -1 : stack[top];
                int rightBound = i;

                // 计算贡献：
                // 左边可选的起始点个数：mid - leftBound
                // 右边可选的结束点个数：rightBound- mid
                long count = (long)(mid -leftBound) * (rightBound - mid);
                totalSum = (totalSum + count * arr[mid]) % MOD;
            }
            stack[++top] = i;
        }
        return (int) totalSum;
    }
}
