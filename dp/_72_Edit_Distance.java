package dp;

public class _72_Edit_Distance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // dp[i][j] 表示 word1 前 i 个字符变成 word2 前 j 个字符的最少步数
        int[][] dp = new int[m+1][n+1];

        // 1. 初始化第一列（全部删除）
        for(int i = 0; i <= m; i++) dp[i][0] = i;

        // 2. 初始化第一行（全部插入）
        for(int j = 0; j <= n; j++) dp[0][j] = j;

        // 3. 递推填表
        for(int i = 1; i <= m; i++){
            char c1 = word1.charAt(i-1);
            for(int j = 1; j <= n; j++){
                char c2 = word2.charAt(j-1);

                if(c1 == c2){
                    // 字符相同，不消耗步数
                    dp[i][j] = dp[i-1][j-1];
                } else { 
                    // 取 三种操作（删除、插入、替换）的最小值 + 1
                    int delete = dp[i-1][j];
                    int insert = dp[i][j-1];
                    int replace = dp[i-1][j-1];

                    dp[i][j] = Math.min(delete, Math.min(insert, replace)) + 1;
                }
            }
        }
        return dp[m][n];
    }
}