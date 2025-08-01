class Solution {
    public int maxProfit(int[] prices) {


        int buy = 0;
        int sell = 1;


        int maxProfit = 0;
        int n = prices.length;
         int currProfit = 0;

        while(sell < n)
        {
            if(prices[sell] > prices[buy])
            {
                currProfit = prices[sell] - prices[buy];
                maxProfit = Math.max(currProfit,maxProfit);
                // sell++;
            }else{

                buy  = sell;
                // buy++;
            }
            sell++;
            // maxProfit = Math.max(currProfit,maxProfit);
        }

        return maxProfit;
        
    }
}