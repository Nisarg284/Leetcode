class Solution {

    public static boolean helper(int n,int m,String s,String p,Boolean[][]dp)
    {

        if(n < 0 && m < 0)
        {
            return true;
        }
        
        if(n >= 0 && m < 0)
        {
            return false;
        }


        if( n < 0)
        {
            for(int i = 0;i<=m;i++)
            {
                if(p.charAt(i) != '*')
                {
                    return false;
                }
            }
            return true;
        }

        if(dp[n][m] != null)
        {
            return dp[n][m];
        }

       if(s.charAt(n) == p.charAt(m) || p.charAt(m) == '?')
       {
            return dp[n][m] = helper(n-1,m-1,s,p,dp); 
       }
       
        else if(p.charAt(m) == '*')
       {
            return dp[n][m] = helper(n-1,m,s,p,dp) || helper(n,m-1,s,p,dp);
       }

       return false;




    }
    public boolean isMatch(String s, String p) {

        int n = s.length();
        int m = p.length();

        // for(int i = 0;i<m;i++)
        // {
        //     if(p.charAt(i) == '*')
        //     {
        //         return true;
        //     }
        // }

        Boolean[][] dp = new Boolean[n][m];
        return helper(n-1,m-1,s,p,dp);

        // return helper(n,m,s,p);
        
    }
}



