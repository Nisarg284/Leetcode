class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        boolean isBuy = false;
        int maxProfit = 0;
        int buyingPrice = -1;

        // now iterate over the prices[] array
        for(int i=0; i<n-1;i++)
        {
            int j = i+1;

            // Buying Condition
            if(prices[i] < prices[j] && !isBuy)
            {
                buyingPrice = prices[i];
                isBuy = true;
            }

            // Selling Condition
            if(prices[i] > prices[j] && isBuy)
            {
                int currentProfit = prices[i] - buyingPrice;
                maxProfit += currentProfit;
                buyingPrice = -1;
                isBuy = false;
            }
        }

        if(isBuy)
        {
            maxProfit += prices[n-1] - buyingPrice;
        }

        return maxProfit;
        
    }
}