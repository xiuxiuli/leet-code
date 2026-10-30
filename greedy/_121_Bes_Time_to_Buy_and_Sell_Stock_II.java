package greedy;

public class _121_Bes_Time_to_Buy_and_Sell_Stock_II{
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        for(int i = 1; i < prices.length; i++){
            // 只要今天价格比昨天高，就把利润加起来
            if(prices[i] > prices[i - 1]){
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}