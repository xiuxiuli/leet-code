pacakge dp;

public class _121_Bes_Time_to_Buy_and_Sell_Stock_II {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int dp0 = 0;            //不持股
        int dp1 = -prices[0];   //持股

        for(int i = 1; i < prices.length; i++){
            int newDp0 = Math.max(dp0, dp1 + prices[i]);
            int newDp1 = Math.max(dp1, dp0 - prices[i]);

            dp0 = newDp0;
            dp1 = newDp1;
        }
        return dp0;
    }
}