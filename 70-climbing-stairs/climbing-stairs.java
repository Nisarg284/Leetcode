class Solution {

    public static int helper(int n, int[]dp){
        if(n == 1 || n == 2){
            return n;
        }

        if(dp[n-1] != -1){
            return dp[n-1];
        }

        int oneJump = helper(n-1,dp);
        int twoJump = helper(n-2,dp);

        return dp[n-1] = oneJump + twoJump;
    }
    public int climbStairs(int n) {

        if(n == 1 || n == 2){
            return n;
        }

        int[]dp = new int[n];

        Arrays.fill(dp,-1);

        return helper(n,dp);

        // int currSteps = 0;

        // int oneJump = climbStairs(n-1);
        // int twoJump = climbStairs(n-2);

        // currSteps = oneJump + twoJump;

        // return currSteps;
        
    }
}