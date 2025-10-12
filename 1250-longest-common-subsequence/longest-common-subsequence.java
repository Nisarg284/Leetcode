class Solution {

    public static int helper(int i,int j,int[][]dp,String s1,String s2)
    {
        if(i < 0 || j < 0)
        {
            return 0;
        }

        if(dp[i][j] != -1)
        {
            return dp[i][j];
        }

        int match = 0;
        int skip = 0;

        if(s1.charAt(i) == s2.charAt(j))
        {
            match = 1 + helper(i-1,j-1,dp,s1,s2);
        }else{
            int skipI = helper(i-1,j,dp,s1,s2);
            int skipJ = helper(i,j-1,dp,s1,s2);

            skip = Math.max(skipI,skipJ);
        }

        return dp[i][j] = Math.max(match,skip);

    }
    public int longestCommonSubsequence(String text1, String text2) {

        int m=text1.length();
        int n=text2.length();

        int[][] dp = new int[m+1][n+1];

        for(int[]arr : dp)
        {
            Arrays.fill(arr,-1);
        }
        return helper(m-1,n-1,dp,text1,text2);
        
    }
}