class Solution {

    public static int helper(int n,int[]dp)
    {
        if(n==0)
        {
            return 0;
        }

        if(dp[n] != -1)
        {
            return dp[n];
        }


        int min = Integer.MAX_VALUE;

        for(int i = 1;i*i<=n;i++)
        {
            int res = 1 + helper(n-i*i,dp);
            min = Math.min(res,min);
        }
        return dp[n] = min;
    }
    public int numSquares(int n) {
        
        if(n==1)
        {
            return 1;
        }

        int[]dp = new int[n+1];
        Arrays.fill(dp,-1);

        int steps = 0;

        return helper(n,dp);
        
    }
}