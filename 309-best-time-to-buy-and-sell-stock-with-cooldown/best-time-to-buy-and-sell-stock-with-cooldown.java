class Solution {

    public static int helper(int idx,int buyIdx,int n,int[]arr,Integer[][]dp){

        if(idx >= n){
            return 0;
        }

        if(dp[idx][buyIdx + 1] != null){
            return dp[idx][buyIdx + 1];
        }

        int skip = helper(idx + 1,buyIdx,n,arr,dp);
        int buy = Integer.MIN_VALUE;
        int sell = Integer.MIN_VALUE;
        if(buyIdx == -1){
            buy = -arr[idx] + helper(idx + 1,idx,n,arr,dp);
        }else{
            sell = arr[idx] + helper(idx + 2,-1,n,arr,dp);
        }

        return dp[idx][buyIdx + 1] = Math.max(skip,Math.max(buy,sell));
    }
    public int maxProfit(int[] prices) {

        int idx = 0;

        int n = prices.length;
        int buyIdx = -1;

        Integer[][] dp = new Integer[n][n+1];

        return helper(idx,buyIdx,n,prices,dp);
        
    }
}