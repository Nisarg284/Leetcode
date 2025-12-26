class Solution {


    public int helper(int i,int j,String s1,String s2,int[][]dp)
    {
        if(i < 0 || j < 0)
        {
            return 0;
        }

        if(dp[i][j] != -1)
        {
            return dp[i][j];
        }

        if(s1.charAt(i) == s2.charAt(j))
        {
            return dp[i][j] = 1 + helper(i-1,j-1,s1,s2,dp);
        }

        return dp[i][j] = Math.max(helper(i-1,j,s1,s2,dp),helper(i,j-1,s1,s2,dp));
        
    }
    public int longestCommonSubsequence(String text1, String text2) {

        int n = text1.length();
        int m = text2.length();

        int[][]dp = new int[n][m];

        for(int[] d : dp)
        {
            Arrays.fill(d,-1);
        }

        

        int i = n-1;
        int j = m-1;

        return helper(i,j,text1,text2,dp);
        
    }
}