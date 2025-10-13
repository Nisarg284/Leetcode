class Solution {

    public static int helper(int i,int j,String s1,String s2,int[][]dp)
    {
        if(i < 0 || j < 0)
        {
            return 0;
        }

        if(dp[i][j] != -1)
        {
            return dp[i][j];
        }

        int take = 0;
        int skip = 0;

        if(s1.charAt(i) == s2.charAt(j))
        {
            take = 1 + helper(i-1,j-1,s1,s2,dp);
        }else{
            skip = Math.max(helper(i-1,j,s1,s2,dp) , helper(i,j-1,s1,s2,dp));
        }

        return dp[i][j] = Math.max(take,skip);
    }
    public int longestPalindromeSubseq(String s) {

        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        String s2 = sb.reverse().toString();

        int[][]dp = new int[n][n];
        for(int[]arr : dp)
        {
            Arrays.fill(arr,-1);
        }

        return helper(n-1,n-1,s,s2,dp);
        
    }
}