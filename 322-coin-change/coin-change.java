class Solution {


    public static int helper(int idx,int amount,int[]coins,int[][]dp){

         if(amount == 0){
            return 0;
        }


        if(idx < 0 || amount < 0){
            return Integer.MAX_VALUE;
        }

        if(dp[idx][amount] != -1){
            return dp[idx][amount];
        }

        int take = Integer.MAX_VALUE;
        int skip = helper(idx - 1,amount,coins,dp);

        if(amount >= coins[idx]){
            int stay = helper(idx,amount - coins[idx],coins,dp);
            if(stay != Integer.MAX_VALUE){
                take = 1 + stay;
            }
        }

        return dp[idx][amount] = Math.min(take,skip);
    }
    public int coinChange(int[] coins, int amount) {

        int n = coins.length;
        int idx = n-1;

        int[][]dp = new int[n][amount+1];

        for(int[]arr : dp){
            Arrays.fill(arr,-1);
        }

        int ans = helper(idx,amount,coins,dp);

        return ans == Integer.MAX_VALUE ? -1 : ans;
        
    }
}