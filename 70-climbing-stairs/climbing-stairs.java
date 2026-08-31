class Solution {

    public static int helper(int[]dp,int n){
        if(n == 1 || n == 2){
            return n;
        }

        if(dp[n] != 0){
            return dp[n];
        }

        int oneSteps = helper(dp,n-1);
        int twoSteps = helper(dp,n-2);

        

        return dp[n] = oneSteps + twoSteps;
    }
    public int climbStairs(int n) {


        int[] dp = new int[n+1];

        return helper(dp,n);
        
    }
}