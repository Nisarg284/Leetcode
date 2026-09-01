class Solution {

    public static int helper(int idx,int[]coins,int amount,int[][]dp){

        if(idx >= coins.length || amount < 0){
            return Integer.MAX_VALUE;
        }

        // if(idx >= coins.length){
        //     return Integer.MAX_VALUE;
        // }

        if(dp[idx][amount] != -1){
            return dp[idx][amount];
        }

        if(amount == 0){
            return 0;
        }
        

        

        // int need = Integer.MAX_VALUE;
        int skip = helper(idx+1,coins,amount,dp);
        int take = Integer.MAX_VALUE;
        if(coins[idx] <= amount){

            int currTake = helper(idx,coins,amount - coins[idx],dp);
            if(currTake != Integer.MAX_VALUE){
                take = 1 + currTake;
            }

        }

        return dp[idx][amount] = Math.min(skip,take);
        
    }
    public int coinChange(int[] coins, int amount) {

        int idx = 0;
        int n = coins.length;
        int[][]dp = new int[n+1][amount+1];

        for(int[]arr : dp){
            Arrays.fill(arr,-1);
        }

        int ans = helper(idx,coins,amount,dp);

        return ans == Integer.MAX_VALUE ? -1 : ans;
        
    }
}