class Solution {

    public static int helper(int i,int j, String s,String t,int[][]dp){
        if(j < 0){
            return 1;
        }

        if(i < 0 || j < 0){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int take = 0;
        int skip = 0;

        if(s.charAt(i) == t.charAt(j)){
            take = helper(i-1,j-1,s,t,dp);
        }

        skip = helper(i-1,j,s,t,dp);

        return dp[i][j] = take + skip;
    }
    public int numDistinct(String s, String t) {


        int n = s.length();
        int m = t.length();

        if(m > n){
            return 0;
        }

        int[][]dp = new int[n][m];

        for(int[]arr : dp){
            Arrays.fill(arr,-1);
        }

        return helper(n-1,m-1,s,t,dp);
        
    }
}