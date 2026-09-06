class Solution {

    public static int helper(int idx,int status,int[]arr,int n,Integer[][]dp){
        if(idx >= n){
            return 0;
        }

        if(dp[idx][status] != null){
            return dp[idx][status];
        }

        int skip = helper(idx+1,status,arr,n,dp);
        int buy = Integer.MIN_VALUE;
        int sell = Integer.MIN_VALUE;
        if(status == 0){
            buy = -arr[idx] + helper(idx + 1,1,arr,n,dp);
        }else{
            sell = arr[idx] + helper(idx + 1,0,arr,n,dp);
        }

        int profit = Math.max(skip,Math.max(buy,sell));

        return dp[idx][status] = profit;
    }
    public int maxProfit(int[] prices) {

        int n = prices.length;
        Integer[][]dp = new Integer[n][2];

        int idx = 0;

        int status = 0;

        return helper(idx,status,prices,n,dp);
        
    }
}