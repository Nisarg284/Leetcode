class Solution {
    public int maxProfit(int[] prices) {

        int n = prices.length;

        int buy = 0;
        int sell = 1;

        int profit = 0;

        while(sell < n)
        {
            if(prices[sell] > prices[buy])
            {
                profit += prices[sell] - prices[buy];
            }

            buy = sell;
            sell++;
        }

        return profit;
        
    }
}