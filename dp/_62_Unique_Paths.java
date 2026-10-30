package dp;

public class _62_Unique_Paths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        // 初始化第一列和第一行
        for(int i = 0; i < m; i++) dp[i][0] = 1;
        for(int j = 0; j < n; j++) dp[0][j] = 1;

        // 递推填表
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                //可能从上方走过来 + 可能从左方走过来
                dp[i][j] = dp[i-1][j] + dp[i][j-1];  
            }
        }
        return dp[m-1][n-1];
    }
}