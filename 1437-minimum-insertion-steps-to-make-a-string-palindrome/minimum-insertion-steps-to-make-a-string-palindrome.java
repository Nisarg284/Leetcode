class Solution {

    public static int helper(int start,int end,int[][]dp,String str)
    {
        if(start >= end)
        {
            return 0;
        }

        if(dp[start][end] != 0)
        {
            return dp[start][end];
        }

        if(str.charAt(start) == str.charAt(end))
        {
            return helper(start+1,end-1,dp,str);
        }

        return dp[start][end] =1 + Math.min( helper(start+1,end,dp,str), helper(start,end-1,dp,str));
    }
    public int minInsertions(String s) {


        int n = s.length();

        int[][] dp = new int[501][501];

        return helper(0,n-1,dp,s);
        
    }
}