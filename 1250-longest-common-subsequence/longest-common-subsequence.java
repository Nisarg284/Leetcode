class Solution {

    public static int helper(int n,int m,String str1,String str2,int[][]dp){
        if(n < 0 || m < 0){
            return 0;
        }

        if(dp[n][m] != -1){
            return dp[n][m];
        }

        int match = 0;
        int misMatch = 0;

        if(str1.charAt(n) == str2.charAt(m)){
            match = 1 + helper(n-1,m-1,str1,str2,dp);
        }else{
            misMatch = Math.max(helper(n-1,m,str1,str2,dp) , helper(n,m-1,str1,str2,dp));
        }

        return dp[n][m] = Math.max(match,misMatch);
    }
    public int longestCommonSubsequence(String text1, String text2) {

        if(text1.isEmpty() || text2.isEmpty()){
            return 0;
        }

        int n = text1.length();
        int m = text2.length();

        int[][]dp = new int[n][m];

        for(int[]arr : dp){
            Arrays.fill(arr,-1);
        }

        return helper(n-1,m-1,text1,text2,dp);
        
    }
}