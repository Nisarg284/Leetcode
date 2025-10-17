class Solution {
    public int maxProfit(int[] prices) {

        int n = prices.length;

        int buy = 0;
        int sell = 1;

        int maxProf = 0;

        while(sell < n)
        {
            if(prices[sell] > prices[buy])
            {
                int currProfit = prices[sell] - prices[buy];

                System.out.println("prices ----> "+ prices[sell]);

                maxProf = Math.max(maxProf,currProfit);
            }else{
                buy = sell;
            }
            sell++;
        }

        return maxProf;
        
    }
}