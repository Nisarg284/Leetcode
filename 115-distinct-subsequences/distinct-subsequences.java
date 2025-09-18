class Solution {

    public static int helper(int i,int j,String s,String t,int[][]dp)
    {
        if(j==0)
        {
            return 1;
        }
        if(i == 0){
            return 0;
        }

        // if(i == 0 && m == 0)
        if(dp[i][j] != -1)
        {
            return dp[i][j];
        }

        char currSChar = s.charAt(i-1);
        char currTChar = t.charAt(j-1);

        int take = helper(i-1,j-1,s,t,dp);
        int skip = helper(i-1,j,s,t,dp);

        if(currSChar == currTChar)
        {
            dp[i][j] = take + skip;
        }else{
            dp[i][j] = skip;
        }

        return dp[i][j];
    }
    public int numDistinct(String s, String t) {

        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n+1][m+1];

        for(int[] d : dp)
        {
            Arrays.fill(d,-1);
        }
        


        return helper(n,m,s,t,dp);

        
    }
}