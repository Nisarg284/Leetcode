class Solution {

    public static int helper(int i,int j,String s,int[][]dp){

        if(i > j){
            return 0;
        }
        if(i == j){
            return 1;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int match = 0;
        int misMatch = 0;

        if(s.charAt(i) == s.charAt(j)){
            match = 2 + helper(i+1,j-1,s,dp);
        }else{
            misMatch = Math.max(helper(i+1,j,s,dp),helper(i,j-1,s,dp));
        }

        return dp[i][j] = Math.max(match,misMatch);
    }
    public int longestPalindromeSubseq(String s) {

        int  n = s.length();

        int i = 0;
        int j = n-1;

        int[][]dp = new int[n][n];

        for(int[]arr : dp){
            Arrays.fill(arr,-1);
        }

        return helper(i,j,s,dp);
        
    }
}