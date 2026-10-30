pacakge greedy;

public class _121_Bes_Time_to_Buy_and_Sell_Stock_greedy {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        
        //在遍历数组时, 维护一个最低股票价
        //并计算最大利润
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int price : prices){
            if(price < minPrice){
                minPrice = price;  // 找到了更低的价格，更新买入点
            } else if(price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }
}