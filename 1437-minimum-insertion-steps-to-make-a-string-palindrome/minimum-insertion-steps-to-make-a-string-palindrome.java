class Solution {


    public static int helper(int start,int end,String str,int[][]dp){
        if(start >= end){
            return 0;
        }

        if(dp[start][end] != 0){
            return dp[start][end];
        }

        int match = Integer.MAX_VALUE;
        int misMatch = Integer.MAX_VALUE;

        if(str.charAt(start) == str.charAt(end)){
            match = helper(start + 1,end - 1,str,dp);
        }else{
            misMatch = 1 + Math.min(helper(start+1,end,str,dp),helper(start,end-1,str,dp));
        }

        return dp[start][end] = Math.min(match,misMatch);
    }
    public int minInsertions(String s) {

        int n = s.length();
        int start = 0;
        int end = n-1;

        int[][] dp = new int[n+1][n+1];


        return helper(start,end,s,dp);


        
    }
}