package dp;

public class _121_Bes_Time_to_Buy_and_Sell_Stock_dp {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        
        // 初始状态：第 0 天
        int dp0 = 0;            // 不持股时的最大收益
        int dp1 = -prices[0];    // 持股时的最大收益

        for(int i = 1; i < prices.length; i++){ //第i天
            dp0 = Math.max(dp0, dp1 + prices[i]); // 卖出股票 或 保持不持股
            dp1 = Math.max(dp1, -prices[i]); // 买入股票 或 保持持股
        }
        return dp0; // 最终肯定是手里不持有股票时收益最高
    }
}