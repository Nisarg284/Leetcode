class Solution {

    public static int helper(int n,int m,String s1,String s2,int[][]dp)
    {
        if(n<0 || m<0)
        {
            return 0;
        }

        if(dp[n][m] != -1)
        {
            return dp[n][m];
        }

        int take = 0;
        int skip = 0;


        if(s1.charAt(n) == s2.charAt(m))
        {
            take = 1 + helper(n-1,m-1,s1,s2,dp);
        }else{
            skip = Math.max(helper(n-1,m,s1,s2,dp) , helper(n,m-1,s1,s2,dp));
        }

        return dp[n][m] = Math.max(take,skip);
    }

    public int minDistance(String word1, String word2) {


        int n = word1.length();
        int m = word2.length();

        int[][]dp = new int[n][m];
        for(int[]arr : dp)
        {
            Arrays.fill(arr,-1);
        }

        int k = helper(n-1,m-1,word1,word2,dp);

        return (n-k) + (m-k);

        
    }
}