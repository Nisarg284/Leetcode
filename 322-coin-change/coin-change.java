class Solution {

    public static int helper(int idx,int target,int[]coins,int[][]dp)
    {
        if(target == 0)
        {
            return 0;
        }

        if(idx < 0)
        {
            return Integer.MAX_VALUE;
        }

        if(dp[idx][target] != -1)
        {
            return dp[idx][target];
        }

        int take = Integer.MAX_VALUE;
        int skip = helper(idx-1,target,coins,dp);
        // int takeAndStay = Integer.MAX_VALUE;

        if(coins[idx] <= target)
        {
            int stay = helper(idx,target - coins[idx],coins,dp);

            if(stay != Integer.MAX_VALUE)
            {
                take = 1 + stay;
            }
            // takeAndStay = 1 + helper(idx,target - coins[idx],coins);
        }

        int findMin = Math.min(take,skip);
        return dp[idx][target] = findMin;
    }
    public int coinChange(int[] coins, int amount) {

        int n = coins.length;

        int[][]dp = new int[n][amount+1];

        for(int[]arr : dp)
        {
            Arrays.fill(arr,-1);
        }

        int ans = helper(n-1,amount,coins,dp);

        return ans == Integer.MAX_VALUE ? -1 : ans;
        
    }
}