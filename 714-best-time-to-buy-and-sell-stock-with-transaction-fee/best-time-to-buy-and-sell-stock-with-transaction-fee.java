class Solution {

    public static int helper(int idx,int status,int fee,int n,int[]prices,int[][]dp)
    {
        if(idx == n)
        {
            return 0;
        }

        if(dp[idx][status] != -1)
        {
            return dp[idx][status];
        }

        int profit = 0;
        if(status == 1)
        {
            int buy = -prices[idx] + helper(idx+1,0,fee,n,prices,dp);
            int notBuy =  helper(idx+1,1,fee,n,prices,dp);

            profit = Math.max(buy,notBuy);
        }else{
            int sell = prices[idx] + helper(idx+1,1,fee,n,prices,dp);
            int notSell = helper(idx+1,0,fee,n,prices,dp);

            profit = Math.max(sell - fee,notSell);
        }

        return dp[idx][status] = profit;
    }
    public int maxProfit(int[] prices, int fee) {

        int n = prices.length;

        int idx = 0;
        int status = 1;

        int[][]dp = new int[n][2];

        for(int[]arr : dp)
        {
            Arrays.fill(arr,-1);
        }

        return helper(idx,status,fee,n,prices,dp);

        // int profit = 0;

        // int buy = 0;
        // int sell = 1;


        // while(sell < n)
        // {
        //     if(prices[sell] >= (prices[buy] + fee))
        //     {
        //         profit += (prices[sell] - (prices[buy] + fee));
        //     }else{
        //         buy = sell;
        //     }
        //     System.out.println(profit);
        //     sell++;
        // }

        // return profit;
        
    }
}