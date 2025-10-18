class Solution {

    public static int helper(int idx,int flag,int[]prices,int n,int[][]dp)
    {
        if(idx == n)
        {
            return 0;
        }


        if(dp[idx][flag] != -1)
        {
            return dp[idx][flag];
        }



        int profit = 0;

        if(flag == 1)
        {
            int buy = -prices[idx] + helper(idx+1,0,prices,n,dp);
            int notBuy = 0 + helper(idx+1,1,prices,n,dp);
            profit = Math.max(buy,notBuy);
        }else{
            int sell = prices[idx] + helper(idx+1,1,prices,n,dp);
            int notSell = helper(idx+1,0,prices,n,dp);
            profit = Math.max(sell,notSell);
        }

        return dp[idx][flag] = profit;
    }
    public int maxProfit(int[] prices) {

        int n = prices.length;

        int[][]dp = new int[n][2];

        for(int arr[] : dp)
        {
            Arrays.fill(arr,-1);
        }

        return helper(0,1,prices,n,dp);
        
    }
}