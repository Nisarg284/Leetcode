class Solution {

    public static int helper(int n,int[]cost,int[]dp)
    {
        if(n < 0)
        {
            return 0;
        }

        if(dp[n] != -1)
        {
            return dp[n];
        }

        int oneStep =  helper(n-1,cost,dp);
        int twoStep =  helper(n-2,cost,dp);

        dp[n] = Math.min(oneStep,twoStep) + cost[n];

        return dp[n];
    }
    public int minCostClimbingStairs(int[] cost) {

        int n = cost.length;
        int[] dp = new int[n];
        

        Arrays.fill(dp,-1);
        dp[0] = cost[0];
        dp[1] = cost[1];
        return Math.min(helper(n-1,cost,dp),helper(n-2,cost,dp));
        
    }
}