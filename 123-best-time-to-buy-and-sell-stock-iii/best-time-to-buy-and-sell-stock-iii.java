class Solution {

    public static int helper(int idx,int status,int transections,int n,int[]prices,int[][][]dp)
    {
        if(idx == n || transections < 0)
        {
            return 0;
        }

        if(dp[idx][status][transections] != -1)
        {
            return dp[idx][status][transections];
        }

        int profit = 0;

        if(status == 1)
        {
            int buy = -prices[idx] + helper(idx+1,0,transections,n,prices,dp);
            int notBuy = helper(idx+1,1,transections,n,prices,dp);
            profit = Math.max(buy,notBuy);
        }else{
            int sell = prices[idx] + helper(idx+1,1,transections-1,n,prices,dp);
            int notSell = helper(idx+1,0,transections,n,prices,dp);

            profit = Math.max(sell,notSell);
        }

        return dp[idx][status][transections] = profit;
    }
    public int maxProfit(int[] prices) {

        int n = prices.length;

        int idx = 0;
        int status = 1;
        int transections = 1;

        int[][][]dp = new int[n][2][2];

        for(int[][]a : dp)
        {
            for(int[]b : a)
            {
                Arrays.fill(b,-1);
            }
        }

        return helper(idx,status,transections,n,prices,dp);
        
    }
}