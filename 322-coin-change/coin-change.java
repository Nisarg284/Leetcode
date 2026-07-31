class Solution {

    public static int helper(int idx,int[]coins,int amount,int[][]dp){

        if(amount == 0){
            return 0;
        }
        
        if( idx < 0 || amount < 0){
            return Integer.MAX_VALUE;
        }

        if(dp[idx][amount] != -1){
            return dp[idx][amount];

        }

        int take = Integer.MAX_VALUE;
        int skip = helper(idx-1,coins,amount,dp);

        if(coins[idx] <= amount){
            int stay = helper(idx,coins,amount - coins[idx],dp);
            if(stay != Integer.MAX_VALUE){
                take = 1 + stay; 
            }
        }

        return dp[idx][amount] = Math.min(take,skip);
    }
    public int coinChange(int[] coins, int amount) {

        int n = coins.length;
        int idx = n-1;

        int[][] dp = new int[n][amount+1];

        for(int[] i : dp){
            Arrays.fill(i,-1);
        }

        int ans = helper(idx,coins,amount,dp);

        return ans == Integer.MAX_VALUE ? -1 : ans;
        
    }
}