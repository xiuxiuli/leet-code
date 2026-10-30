package dp;

public class _64_Minimum_Path_Sum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        // dp[i][j] 是指到达格子[i][j]的累加最小值

        // 行， 横向. 初始化第一行（dp[i][j]只能是向右行得来的， 它上面没有行）
        for(int j = 1; j < n; j++){
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }

        //列， 竖向. 初始化第一列（只能向下）
        for(int i = 1; i < m; i++){
            dp[i][0] = dp[i-1][0] +grid[i][0];
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }
}