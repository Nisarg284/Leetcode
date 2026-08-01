class Solution {

    public static int helper(int idx,int amount,int[]coins,int[][]dp){

        if(amount == 0){
            return 1;
        }

        if(idx < 0 || amount < 0){
            return 0;
        }

        if(dp[idx][amount] != -1){
            return dp[idx][amount];
        }

        int take = 0;
        int skip = helper(idx-1,amount,coins,dp);

        if(coins[idx] <= amount){
            take = helper(idx,amount - coins[idx],coins,dp);
        }

        return dp[idx][amount] = take + skip;
    }

    public int change(int amount, int[] coins) {

        int n = coins.length;
        int idx = n-1;

        int[][] dp = new int[n][amount+1];

        for(int[]arr : dp){
            Arrays.fill(arr,-1);
        }

        return helper(idx,amount,coins,dp);
        
    }
}