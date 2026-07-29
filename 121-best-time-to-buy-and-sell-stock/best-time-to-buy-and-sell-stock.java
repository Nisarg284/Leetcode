class Solution {
    public int maxProfit(int[] prices) {

        int maxProfit = 0;

        int buy = 0;
        int sell = 1;

        int n = prices.length;

        while(sell < n){

            if(prices[buy] < prices[sell]){
                int currProfit = prices[sell] - prices[buy];
                maxProfit = Math.max(currProfit,maxProfit);
            }else{
                buy = sell;
            }

            sell++;
        }

        return maxProfit;
        
    }
}