class Solution {

    public static int helper(int idx,int status,int k,int[]prices,int n,Integer[][][]dp){
        if(idx >= n || k < 0){
            return 0;
        }

        if(dp[idx][k][status] != null){
            return dp[idx][k][status];
        }


        int profit = 0;
        if(status == 1){
            int buy = -prices[idx] + helper(idx + 1,0,k-1,prices,n,dp);
            int notBuy = helper(idx + 1,status,k,prices,n,dp);
            profit = Math.max(buy,notBuy);
        }else{
            int sell = prices[idx] + helper(idx + 1,1,k,prices,n,dp);
            int notSell = helper(idx + 1,status,k,prices,n,dp);
            profit = Math.max(sell,notSell);

        }

        return dp[idx][k][status] = profit;
    }
    public int maxProfit(int k, int[] prices) {


        int n = prices.length;
        int status = 1;

        Integer[][][]dp = new Integer[n][k+1][status + 1];


        int idx = 0;

        return helper(idx,status,k,prices,n,dp);
        
    }
}