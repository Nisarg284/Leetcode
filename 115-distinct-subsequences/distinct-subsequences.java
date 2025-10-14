class Solution {

    public static int helper(int n,int m,String s,String t,int[][]dp)
    {
        if(m < 0)
        {
            return 1;
        }

        if(n < 0)
        {
            return 0;
        }

        if(dp[n][m] != -1)
        {
            return dp[n][m];
        }

        int take = helper(n-1,m-1,s,t,dp);
        int skip = helper(n-1,m,s,t,dp);

        if(s.charAt(n) == t.charAt(m))
        {
            return dp[n][m] = take + skip;
        }

        return dp[n][m] = skip;
    }
    public int numDistinct(String s, String t) {

        int n = s.length();
        int m = t.length();

        int[][]dp = new int[n][m];

        for(int[]arr : dp)
        {
            Arrays.fill(arr,-1);
        }

        return helper(n-1,m-1,s,t,dp);
        
    }
}