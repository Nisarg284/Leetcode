class Solution {

    public static int helper(int n,int m,String s1,String s2,int[][]dp)
    {
        
        if(m < 0)
        {
            return n+1;
        }

        if(n < 0)
        {
            return m+1;
        }

        if(dp[n][m] != -1)
        {
            return dp[n][m];
        }

        if(s1.charAt(n) == s2.charAt(m))
        {
            return dp[n][m] = helper(n-1,m-1,s1,s2,dp);
        }else{
            int insert = helper(n,m-1,s1,s2,dp);
            int delete = helper(n-1,m,s1,s2,dp);
            int replace = helper(n-1,m-1,s1,s2,dp);

            return dp[n][m] = 1 + Math.min(insert,Math.min(delete,replace));
        }
    }
    public int minDistance(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int[][]dp = new int[n][m];

        for(int[]arr : dp)
        {
            Arrays.fill(arr,-1);
        }

        // if(n==0)
        // {
        //     return m;
        // }

        // if(m == 0)
        // {
        //     return n;
        // }

        return helper(n-1,m-1,word1,word2,dp);
        
    }
}