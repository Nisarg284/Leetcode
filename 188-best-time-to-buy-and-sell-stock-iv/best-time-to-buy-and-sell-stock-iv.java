class Solution {

    public static int helper(int idx,int status,int k,int n, int[]prices,int[][][]dp)
    {
        if(idx == n || k < 0)
        {
            System.out.println(k);
            return 0;
        }

        if(dp[idx][status][k] != -1)
        {
            return dp[idx][status][k];
        }


        int profit = 0;

        if(status == 1)
        {
            int buy = -prices[idx] + helper(idx+1,0,k-1,n,prices,dp);
            int notBuy =  helper(idx+1,1,k,n,prices,dp);

            profit = Math.max(buy,notBuy);
        }else{
            int sell = prices[idx] + helper(idx+1,1,k-1,n,prices,dp);
            int notSell = helper(idx+1,0,k,n,prices,dp);

            profit = Math.max(sell,notSell);
        }

        return dp[idx][status][k] = profit;
    }
    public int maxProfit(int k, int[] prices) {

        int n = prices.length;

        int idx = 0;
        int status = 1;

        int[][][]dp = new int[n][2][k*2];

        for(int[][]arr : dp)
        {
            for(int[]a : arr)
            {
                Arrays.fill(a,-1);
            }
        }
        return helper(idx,status,(k*2)-1,n,prices,dp);
        
    }
}