class Solution {

    public int helper(int n,int m,Integer[][]dp)
    {
        if(n <= 0 || m <= 0)
        {
            return 0;
        }

        if(n == 1 && m == 1)
        {
            return 1;
        }

        if(dp[n][m] != null)
        {
            return dp[n][m];
        }


        return dp[n][m] = helper(n-1,m,dp) + helper(n,m-1,dp);
    }
    public int uniquePaths(int m, int n) {

        // int[][]dp = new int[m][n];


        Integer[][] dp = new Integer[m+1][n+1];


        return helper(m,n,dp);
        
    }
}