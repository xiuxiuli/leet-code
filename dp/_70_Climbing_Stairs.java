package dp;

public class _70_Climbing_Stairs {
    // n = 1, 1
    // n = 2, 2
    // 状态递推

    public int climbStairs(int n) {
        if(n <= 2) return n;

        int p = 1; // dp[i-2]
        int q = 2; // dp[i-1]

        for(int i = 3; i <= n; i++){
            int cur = p + q;
            p = q;
            q = cur;
        }
        return q;
    }
}