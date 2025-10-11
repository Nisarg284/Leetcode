class Solution {

    public static int helper(int idx,int target,int[]arr,int[][]dp)
    {
        if(target == 0)
        {
            return 1;
        }

        if(idx < 0)
        {
            return 0;
        }

        if(dp[idx][target] != -1)
        {
            return dp[idx][target];
        }

        int take = 0;
        // int stay = 0;
        int skip = helper(idx -1,target,arr,dp);

        if(arr[idx] <= target)
        {
            // stay = helper(idx,target - arr[idx],arr);
            take = helper(idx,target - arr[idx],arr,dp);
        }

        return dp[idx][target] = take + skip;
    }
    public int change(int amount, int[] coins) {

        int n = coins.length;

        int[][]dp = new int[n][amount + 1];

        for(int[]arr : dp)
        {
            Arrays.fill(arr,-1);
        }

        return helper(n-1,amount,coins,dp);
        
    }
}