class Solution {
    public int maxProfit(int[] prices) {
        
        int buy =0;
        int sell=1;

        int maxProfit=0;
        int profit;

        while(sell<prices.length)
        {
            // Buy only when
            if(prices[buy] < prices[sell])
            {
                profit = prices[sell] -  prices[buy];
                maxProfit = Math.max(profit,maxProfit);
            }else{
                buy = sell;
            }
            sell++;
        }
        return maxProfit;
        
    }
}