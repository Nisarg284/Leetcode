class Solution {

    public static int helper(int idx,int status,int fee,int[]arr,Integer[][] dp){
        if(idx >= arr.length){
            return 0;
        }

        if(dp[idx][status] != null){
            return dp[idx][status];
        }

        int skip = helper(idx + 1,status,fee,arr,dp);
        int buy = Integer.MIN_VALUE;
        int sell = Integer.MIN_VALUE;
        if(status == 0){
            buy = -(arr[idx] + fee) + helper(idx + 1,1,fee,arr,dp);
        }else{
            sell = arr[idx] + helper(idx + 1,0,fee,arr,dp);
        }

        return dp[idx][status] = Math.max(skip,Math.max(buy,sell));
    }
    public int maxProfit(int[] prices, int fee) {

        int n = prices.length;
        int idx = 0;
        int status = 0;
        Integer[][] dp = new Integer[n][2];


        return helper(idx,status,fee,prices,dp);
        
    }
}