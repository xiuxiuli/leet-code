package dp;

public class _322_Coin_Change {
    public int coinChange(int[] coins, int amount) {
        // dp[i] 表示凑成金额 i 所需的最少硬币数
        int max = amount + 1;
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, max);

        dp[0] = 0;

        for(int i = 1; i <= amount; i++) {
            for(int coin : coins){
                if(i - coin >= 0){
                    dp[i] = Math.min(dp[i], dp[i-coin]+1);
                }
            }
        }

        return dp[amount] > amount ? -1: dp[amount];
    }
}