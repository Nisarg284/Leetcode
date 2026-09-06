class Solution {

    public static int helper(int idx,int status,int transactions,int n,int[]arr,Integer[][][]dp){

        if(idx >= n){
            return 0;
        }

        if(dp[idx][status][transactions] != null){
            return dp[idx][status][transactions];
        }

        int skip = helper(idx + 1,status,transactions,n,arr,dp);
        int buy = Integer.MIN_VALUE;
        int sell = Integer.MIN_VALUE;

        if(status == 0){
            if(transactions > 0){
                buy = -arr[idx] + helper(idx + 1,1,transactions - 1,n,arr,dp);
            }
        }else{
            sell = arr[idx] + helper(idx + 1,0,transactions,n,arr,dp);
        }

        return dp[idx][status][transactions] = Math.max(skip,Math.max(buy,sell));
    }
    public int maxProfit(int[] prices) {

        int idx = 0;
        int status = 0;
        int transactions = 2;
        int n = prices.length;

        Integer[][][]dp = new Integer[n][2][3];

        return helper(idx,status,transactions,n,prices,dp);
        
    }
}